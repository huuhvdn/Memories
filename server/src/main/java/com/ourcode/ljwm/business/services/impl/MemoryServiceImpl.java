package com.ourcode.ljwm.business.services.impl;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ourcode.ljwm.business.services.MemoryService;
import com.ourcode.ljwm.domain.dtos.ImageDTO;
import com.ourcode.ljwm.domain.dtos.MemoryDTO;
import com.ourcode.ljwm.domain.entities.MemoryEntity;
import com.ourcode.ljwm.domain.mappers.MemoryMapper;
import com.ourcode.ljwm.infrastructure.repositories.MemoryRepository;

@Service
public class MemoryServiceImpl implements MemoryService {
    private final MemoryRepository memoryRepository;
    @Autowired
    private ImageServiceImpl imageServiceImpl;
    
    @Autowired
    public MemoryServiceImpl(MemoryRepository memoryRepository){
        this.memoryRepository = memoryRepository;
    }
    @Override
    public MemoryDTO addMemory(MemoryDTO memory,MultipartFile file){

        ImageDTO image = imageServiceImpl.uploadImage(file);

        memory.setImageDTO(image);
        memory.setId(UUID.randomUUID());
        memory.setCreateAt(LocalDateTime.now());
        memory.setUpdateAt(LocalDateTime.now());

        MemoryEntity memoryEntity = MemoryMapper.toEntity(memory);

        return MemoryMapper.toDTO(memoryRepository.save(memoryEntity));
    }
    @Override
    public MemoryDTO getMemoryById(UUID id){
        try {
            MemoryEntity entity = memoryRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
            return MemoryMapper.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
    @Override
    public List<MemoryDTO> getAllMemory(){
        List<MemoryDTO> memories = memoryRepository.findAll().stream().map(MemoryMapper::toDTO).collect(Collectors.toList());
        return memories;
    }
    @Override
    public MemoryDTO updateMemory(MemoryDTO uMemory){
        try {
            MemoryEntity oldMemoryEntity = memoryRepository.findById(uMemory.getId()).orElseThrow(()-> new RuntimeException("yeah"));
            MemoryEntity uploadMemoryEntity = MemoryMapper.toEntity(uMemory);

            if(oldMemoryEntity.getTitle() != uploadMemoryEntity.getTitle()){
                oldMemoryEntity.setTitle(uploadMemoryEntity.getTitle());
            }
            if(oldMemoryEntity.getLocation() != uploadMemoryEntity.getLocation()){
                oldMemoryEntity.setLocation(uploadMemoryEntity.getLocation());
            }
            if(oldMemoryEntity.getEventDate() != uploadMemoryEntity.getEventDate()){
                oldMemoryEntity.setEventDate(uploadMemoryEntity.getEventDate());
            }
            if(oldMemoryEntity.getImageEntity().getId() != uploadMemoryEntity.getImageEntity().getId()){
                oldMemoryEntity.setImageEntity(uploadMemoryEntity.getImageEntity());
            }

        
            return MemoryMapper.toDTO(memoryRepository.save(oldMemoryEntity));
            
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
    @Override
    public void deleteMemory(UUID id){
        memoryRepository.deleteById(id);
        
    }
}
