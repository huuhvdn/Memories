package com.ourcode.memories.domain.service.image;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageDTO saveImage(MultipartFile file) throws IOException;

    List<ImageDTO> saveImages(List<MultipartFile> files) throws IOException;

    ImageDTO getImage(Long id);

    List<ImageDTO> getAllImages();

    ImageDTO updateImage(Long id, MultipartFile file) throws IOException;

    void deleteImage(Long id);
}
