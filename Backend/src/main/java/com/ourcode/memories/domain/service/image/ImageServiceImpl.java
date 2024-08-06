package com.ourcode.memories.domain.service.image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.memories.domain.entity.Image;
import com.ourcode.memories.domain.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
    private static final String IMAGE_DIRECTORY = "images/";
    @Autowired
    private ImageRepository imageRepository;
    public List<ImageDTO> saveImages(List<MultipartFile> files) throws IOException {
        return files.stream().map(file ->{
            try {
                return saveImage(file);
            } catch (IOException e) {
                throw new RuntimeException("Error save image",e);
            }
        }).collect(Collectors.toList());
    }

    public ImageDTO saveImage(MultipartFile file) throws IOException{

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(IMAGE_DIRECTORY, fileName);
        Files.copy(file.getInputStream(),filePath);

        Image image = new Image();
        image.setName(fileName);
        image.setType(file.getContentType());
        image.setPath(filePath.toString());
        image.setUploadTime(LocalDateTime.now());

        image = imageRepository.save(image);

        return ImageMapper.toDTO(image);
    }
    public ImageDTO getImage(Long id){
        Image image = imageRepository.findById(id).orElseThrow(()-> new RuntimeException("Image not found."));
        return ImageMapper.toDTO(image);
    }
    public List<ImageDTO> getAllImages(){
        return imageRepository.findAll().stream().map(ImageMapper::toDTO).collect(Collectors.toList());
    }
    public ImageDTO updateImage(Long id,MultipartFile file) throws IOException {
        Image image = imageRepository.findById(id).orElseThrow(()-> new RuntimeException("Image not found"));
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(IMAGE_DIRECTORY,fileName);
        Files.copy(file.getInputStream(),filePath);

        image.setName(fileName);
        image.setType(file.getContentType());
        image.setPath(filePath.toString());
        image.setUploadTime(LocalDateTime.now());
        image = imageRepository.save(image);

        return ImageMapper.toDTO(image);
    }
    public void deleteImage(Long id){
        Image image = imageRepository.findById(id).orElseThrow(()-> new RuntimeException("Image not found"));
        imageRepository.delete(image);
    }
}
