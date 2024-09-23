package com.ourcode.savememories.services.Memory;

import java.util.UUID;

import com.ourcode.savememories.dtos.MemoryDTO;

import java.util.List;

public interface MemoryService {
    MemoryDTO createMemory(MemoryDTO memoryDTO);
    List<MemoryDTO> getAllMemories();
    MemoryDTO getMemoryById(UUID id);
    MemoryDTO updateMemory(UUID id, MemoryDTO memoryDTO);
    void deleteMemory(UUID id);
}