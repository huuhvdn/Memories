package com.ourcode.savememories.controller;

import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RestController;

import com.ourcode.savememories.dtos.MemoryDTO;
import com.ourcode.savememories.services.Memory.MemoryServiceImpl;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {
    @Autowired
    private MemoryServiceImpl memoryServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<MemoryDTO> createMemory(@RequestBody MemoryDTO memoryDTO){
        MemoryDTO createdMemory = memoryServiceImpl.createMemory(memoryDTO);
        return new ResponseEntity<>(createdMemory,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemoryDTO> getMemoryById(@PathVariable UUID id){
        MemoryDTO memoryDTO = memoryServiceImpl.getMemoryById(id);
        return new ResponseEntity<>(memoryDTO,HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<MemoryDTO>> getAllMemory(){
        List<MemoryDTO> memories = memoryServiceImpl.getAllMemories();
        return new ResponseEntity<>(memories,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MemoryDTO> updateMemory(@PathVariable UUID id,@RequestBody MemoryDTO memoryDTO){
        MemoryDTO updateMemory = memoryServiceImpl.updateMemory(id, memoryDTO);
        return ResponseEntity.ok(updateMemory);
    }
    @DeleteMapping("/detete/{id}")
    public ResponseEntity<Void> deleteMemory(@PathVariable UUID id){
        memoryServiceImpl.deleteMemory(id);
        return ResponseEntity.noContent().build();
    }
}
