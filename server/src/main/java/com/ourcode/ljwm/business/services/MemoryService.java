package com.ourcode.ljwm.business.services;

import java.util.UUID;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.domain.dtos.MemoryDTO;

public interface MemoryService {
    MemoryDTO addMemory(MemoryDTO memory,MultipartFile file);
    MemoryDTO getMemoryById(UUID id);
    List<MemoryDTO> getAllMemory();
    MemoryDTO updateMemory(MemoryDTO uploadMemory);
    void deleteMemory(UUID id);
}
