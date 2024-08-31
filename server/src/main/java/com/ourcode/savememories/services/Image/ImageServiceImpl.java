package com.ourcode.savememories.services.Image;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public List<ImageDTO> findAll(){
        return imageRepository.findAll().stream().map(ImageMapper::toDTO).collect(Collectors.toList());
    }
    public Optional<ImageDTO> findById(UUID id){
        return imageRepository.findById(id).map(ImageMapper::toDTO);
    }
    public ImageDTO save(ImageDTO dto){
        Image entity = new Image();
        entity = ImageMapper.toEntity(dto);
        return ImageMapper.toDTO(imageRepository.save(entity));
    }
    public void deleteById(UUID id){
        imageRepository.deleteById(id);
    }
}
