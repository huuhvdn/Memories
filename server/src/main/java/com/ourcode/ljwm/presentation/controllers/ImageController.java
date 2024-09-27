package com.ourcode.ljwm.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.business.services.impl.ImageServiceImpl;
import com.ourcode.ljwm.domain.dtos.ImageDTO;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @PostMapping("/upload")
    public ResponseEntity<ImageDTO> uploadImage(@RequestParam("image") MultipartFile image){
        ImageDTO imageUpload = imageServiceImpl.uploadImage(image);
        return new ResponseEntity<>(imageUpload,HttpStatus.CREATED);
    }
}
