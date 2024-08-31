package com.ourcode.savememories.services.Image;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ourcode.savememories.model.image.ImageDTO;

public interface ImageService {
    List<ImageDTO> findAll();
    Optional<ImageDTO> findById(UUID id);
    ImageDTO save(ImageDTO dto);
    void deleteById(UUID id);
}
