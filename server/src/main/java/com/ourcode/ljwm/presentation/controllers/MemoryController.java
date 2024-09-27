package com.ourcode.ljwm.presentation.controllers;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.business.services.impl.MemoryServiceImpl;
import com.ourcode.ljwm.domain.dtos.MemoryDTO;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {
    @Autowired
    private MemoryServiceImpl memoryServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<MemoryDTO> createMemory(@RequestPart("data") MemoryDTO memory, @RequestPart("image") MultipartFile file){
        MemoryDTO createMemory = memoryServiceImpl.addMemory(memory, file);
        return new ResponseEntity<>(createMemory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoryDTO> getMemoryById(@PathVariable UUID id){
        MemoryDTO memory = memoryServiceImpl.getMemoryById(id);
        return new ResponseEntity<>(memory,HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<MemoryDTO>> getAllMemory(){
        List<MemoryDTO> memories = memoryServiceImpl.getAllMemory();
        return new ResponseEntity<>(memories,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<MemoryDTO> updateMemory(@RequestBody MemoryDTO uploadMemory){
        MemoryDTO memory = memoryServiceImpl.updateMemory(uploadMemory);
        return new ResponseEntity<>(memory,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMemory(@PathVariable UUID id){
        memoryServiceImpl.deleteMemory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
