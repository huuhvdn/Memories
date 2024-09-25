package com.ourcode.savememories.domain.service.image;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.savememories.domain.model.image.ImageDTO;
import com.ourcode.savememories.domain.model.image.ImageEntity;
import com.ourcode.savememories.domain.model.image.ImageMapper;
import com.ourcode.savememories.infrastructure.repository.ImageRepository;

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
        ImageEntity entity = new ImageEntity();
        entity = ImageMapper.toEntity(dto);
        return ImageMapper.toDTO(imageRepository.save(entity));
    }
    @Override
    public void deleteById(UUID id){
        imageRepository.deleteById(id);
    }
    @Override
    public ImageDTO uploadImage(MultipartFile file){
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

        try {
            file.transferTo(new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Failed to save file: "+ e.getMessage(),e);
        }

        ImageEntity image =  new ImageEntity();
        image.setName(fileName);
        image.setPath(filePath);
        image.setType(fileType);
        image.setCreateAt(LocalDateTime.now());

        return ImageMapper.toDTO(imageRepository.save(image));
    }
}
