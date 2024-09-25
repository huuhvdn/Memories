package com.ourcode.savememories.domain.service.memory;

import java.util.UUID;

import com.ourcode.savememories.domain.model.memory.MemoryDTO;

import java.util.List;

public interface MemoryService {
    MemoryDTO createMemory(MemoryDTO memoryDTO);
    List<MemoryDTO> getAllMemories();
    MemoryDTO getMemoryById(UUID id);
    MemoryDTO updateMemory(UUID id, MemoryDTO memoryDTO);
    void deleteMemory(UUID id);
}