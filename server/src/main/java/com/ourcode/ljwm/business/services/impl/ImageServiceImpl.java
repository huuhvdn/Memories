package com.ourcode.ljwm.business.services.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.business.services.ImageService;
import com.ourcode.ljwm.domain.dtos.ImageDTO;
import com.ourcode.ljwm.domain.entities.ImageEntity;
import com.ourcode.ljwm.domain.mappers.ImageMapper;
import com.ourcode.ljwm.infrastructure.repositories.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Value("${upload.dir}")
    private String uploadDir;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }
    @Override
    public ImageDTO uploadImage(MultipartFile image){
        if(image.isEmpty()){
            throw new IllegalArgumentException("File must not be empty or null");
        }

        File directory = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }
        UUID id = UUID.randomUUID();

        String name = id + image.getOriginalFilename();
        String type = image.getContentType();
       //String path = uploadDir + File.separator + name;
        Path filePath =  Paths.get(uploadDir,name);
        try {
            //image.transferTo(new File(path));
            Files.write(filePath,image.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to save file: " + e.getMessage(),e);
        }

        ImageEntity uploadInfo = new ImageEntity();

        uploadInfo.setId(id);
        uploadInfo.setName(name);
        uploadInfo.setType(type);
        uploadInfo.setPath(filePath.toString());


        return ImageMapper.toDTO(imageRepository.save(uploadInfo));
    }
    @Override
    public void deleteImage(UUID id){
        imageRepository.deleteById(id);
    }
}
