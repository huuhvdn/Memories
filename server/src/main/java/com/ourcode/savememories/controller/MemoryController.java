package com.ourcode.savememories.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ourcode.savememories.model.memory.MemoryDTO;
import com.ourcode.savememories.services.Memory.MemoryService;

@Controller
@RequestMapping("/api/memories")
public class MemoryController {
    @Autowired
    private MemoryService memoryService;

    @PostMapping("/create")
    public ResponseEntity<MemoryDTO> createMemory(@RequestBody MemoryDTO memoryDTO){
        MemoryDTO createdMemory = memoryService.createMemory(memoryDTO);
        return ResponseEntity.ok(createdMemory);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemoryDTO> getMemoryById(@PathVariable UUID id){
        MemoryDTO memoryDTO = memoryService.getMemoryById(id);
        return ResponseEntity.ok(memoryDTO);
    }
}
