package com.ourcode.savememories.services.Memory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import com.ourcode.savememories.model.image.ImageMapper;
import com.ourcode.savememories.model.memory.Memory;
import com.ourcode.savememories.model.memory.MemoryDTO;
import com.ourcode.savememories.model.memory.MemoryMapper;
import com.ourcode.savememories.repository.MemoryRepository;

@Service
public class MemoryServiceImpl implements MemoryService {
    private final MemoryRepository memoryRepository;

    @Autowired
    public MemoryServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public MemoryDTO createMemory(MemoryDTO memoryDTO) {
        if (memoryDTO == null) {
            throw new IllegalArgumentException("MemoryDTO cannot be null");
        }

        Memory memory = MemoryMapper.toEntity(memoryDTO);
        Memory savedMemory = memoryRepository.save(memory);

        return MemoryMapper.toDTO(savedMemory);
    }

    @Override
    public List<MemoryDTO> getAllMemories() {
        List<Memory> memories = memoryRepository.findAll();
        return memories.stream()
                .map(MemoryMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public MemoryDTO getMemoryById(UUID id) {
        Memory memory = memoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Memory not found"));
        return MemoryMapper.toDTO(memory);
    }

    @Override
    public MemoryDTO updateMemory(UUID id, MemoryDTO memoryDTO) {
        Memory memory = memoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Memory not found"));
        if (memoryDTO.getTitle() != null) {
            memory.setTitle(memoryDTO.getTitle());
        }
        if (memoryDTO.getEventDate() != null) {
            memory.setEventDate(memoryDTO.getEventDate());
        }
        if (memoryDTO.getImageDTO() != null) {
            memory.setImage(ImageMapper.toEntity(memoryDTO.getImageDTO()));
        }

        Memory updatedMemory = memoryRepository.save(memory);

        return MemoryMapper.toDTO(updatedMemory);
    }

    @Override
    public void deleteMemory(UUID id) {
        Memory memory = memoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Memory not found"));
        memoryRepository.delete(memory);
    }
}