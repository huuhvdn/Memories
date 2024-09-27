package com.ourcode.ljwm.business.services;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.domain.dtos.ImageDTO;

public interface ImageService {
    ImageDTO uploadImage(MultipartFile image);    
    void deleteImage(UUID id);
}
