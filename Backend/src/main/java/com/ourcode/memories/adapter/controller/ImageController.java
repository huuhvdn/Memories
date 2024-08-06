package com.ourcode.memories.adapter.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.memories.domain.service.image.ImageDTO;
import com.ourcode.memories.domain.service.image.ImageService;
import com.ourcode.memories.domain.service.image.ImageServiceImpl;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping("/uploadlistimage")
    public ResponseEntity<List<ImageDTO>> uploadImages(@RequestParam("files") List<MultipartFile> files) throws IOException{
        List<ImageDTO> imageDTOs = imageService.saveImages(files);
        return new ResponseEntity<>(imageDTOs,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable Long id){
        ImageDTO dto = imageService.getImage(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<ImageDTO>> getAllImage(){
        List<ImageDTO> imageDTOs = imageService.getAllImages();
        return new ResponseEntity<>(imageDTOs,HttpStatus.OK);
    }
    @PutMapping("/updateimage/{id}")
    public ResponseEntity<ImageDTO> updateImage(@PathVariable Long id,@RequestParam("file") MultipartFile file) throws IOException {
        ImageDTO imageDTO = imageService.updateImage(id,file);
        return new ResponseEntity<>(imageDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id){
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
