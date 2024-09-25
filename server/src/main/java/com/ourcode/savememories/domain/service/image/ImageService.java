package com.ourcode.savememories.domain.service.image;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.ourcode.savememories.domain.model.image.ImageDTO;

public interface ImageService {
    List<ImageDTO> findAll();
    Optional<ImageDTO> findById(UUID id);
    ImageDTO save(ImageDTO dto);
    void deleteById(UUID id);
    ImageDTO uploadImage(MultipartFile file);
    boolean isValidImageType(String fileType);
}
