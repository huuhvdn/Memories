package com.ourcode.savememories.services.Image;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.savememories.model.image.Image;
import com.ourcode.savememories.model.image.ImageDTO;
import com.ourcode.savememories.model.image.ImageMapper;
import com.ourcode.savememories.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;
    @Value("${upload.dir}")
    private String uploadDir;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }
    @Override
    public List<ImageDTO> findAll(){
        return imageRepository.findAll().stream().map(ImageMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public Optional<ImageDTO> findById(UUID id){
        return imageRepository.findById(id).map(ImageMapper::toDTO);
    }
    @Override
    public ImageDTO save(ImageDTO dto){
        Image entity = new Image();
        entity = ImageMapper.toEntity(dto);
        return ImageMapper.toDTO(imageRepository.save(entity));
    }
    @Override
    public void deleteById(UUID id){
        imageRepository.deleteById(id);
    }
    @Override
    public ImageDTO uploadImage(MultipartFile file)throws IOException{
        if(file == null || file.isEmpty()){
            throw new IllegalArgumentException("File must not be empty or null");
        }
        File directory = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        String filePath = uploadDir + File.separator + fileName;
        String fileType = file.getContentType();

        if(!isValidImageType(fileType)){
            throw new IllegalArgumentException("Invalid image Type:"+ fileType);
        }
        try {
            file.transferTo(new File(filePath));
        } catch (Exception e) {
            throw new IOException("Failed to save file: "+ e.getMessage(),e);
        }

        Image image =  new Image();
        image.setName(fileName);
        image.setPath(filePath);
        image.setType(fileType);
        image.setCreateAt(LocalDateTime.now());

        return ImageMapper.toDTO(imageRepository.save(image));
    }
    @Override
    public boolean isValidImageType(String fileType){
        return fileType != null && (fileType.equals("image/jpge")||fileType.equals("image/png")||fileType.equals("image/gif")||fileType.equals("image/bmp"));
    }
}
