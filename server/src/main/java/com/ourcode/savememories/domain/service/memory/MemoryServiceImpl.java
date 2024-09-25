package com.ourcode.savememories.domain.service.memory;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import com.ourcode.savememories.domain.model.image.ImageMapper;
import com.ourcode.savememories.domain.model.memory.MemoryDTO;
import com.ourcode.savememories.domain.model.memory.MemoryEntity;
import com.ourcode.savememories.domain.model.memory.MemoryMapper;
import com.ourcode.savememories.infrastructure.exception.memory.MemoryNotFoundException;
import com.ourcode.savememories.infrastructure.repository.MemoryRepository;

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

        MemoryEntity memory = MemoryMapper.toEntity(memoryDTO);
        MemoryEntity savedMemory = memoryRepository.save(memory);

        return MemoryMapper.toDTO(savedMemory);
    }

    @Override
    public List<MemoryDTO> getAllMemories() {
        List<MemoryEntity> memories = memoryRepository.findAll();
        return memories.stream()
                .map(MemoryMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public MemoryDTO getMemoryById(UUID id) {
        MemoryEntity memory = memoryRepository.findById(id).orElseThrow(() -> new MemoryNotFoundException(id));
        return MemoryMapper.toDTO(memory);
    }

    @Override
    public MemoryDTO updateMemory(UUID id, MemoryDTO memoryDTO) {
        MemoryEntity memory = memoryRepository.findById(id).orElseThrow(() -> new MemoryNotFoundException(id));
        if (memoryDTO.getTitle() != null) {
            memory.setTitle(memoryDTO.getTitle());
        }
        if (memoryDTO.getEventDate() != null) {
            memory.setEventDate(memoryDTO.getEventDate());
        }
        if (memoryDTO.getImageDTO() != null) {
            memory.setImage(ImageMapper.toEntity(memoryDTO.getImageDTO()));
        }

        MemoryEntity updatedMemory = memoryRepository.save(memory);

        return MemoryMapper.toDTO(updatedMemory);
    }

    @Override
    public void deleteMemory(UUID id) {
        MemoryEntity memory = memoryRepository.findById(id).orElseThrow(() -> new MemoryNotFoundException(id));
        memoryRepository.delete(memory);
    }
}