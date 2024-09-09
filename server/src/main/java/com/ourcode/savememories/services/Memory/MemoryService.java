package com.ourcode.savememories.services.Memory;

import java.util.UUID;

import java.util.List;
import com.ourcode.savememories.model.memory.MemoryDTO;

public interface MemoryService {
    MemoryDTO createMemory(MemoryDTO memoryDTO);
    List<MemoryDTO> getAllMemories();
    MemoryDTO getMemoryById(UUID id);
    MemoryDTO updateMemory(UUID id, MemoryDTO memoryDTO); // Đảm bảo phương thức này có trong interface
    void deleteMemory(UUID id);
}