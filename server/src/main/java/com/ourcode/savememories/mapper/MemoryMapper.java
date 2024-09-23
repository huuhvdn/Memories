package com.ourcode.savememories.mapper;

import com.ourcode.savememories.dtos.ImageDTO;
import com.ourcode.savememories.dtos.MemoryDTO;
import com.ourcode.savememories.entities.Image;
import com.ourcode.savememories.entities.Memory;

public class MemoryMapper {
    public static Memory toEntity(MemoryDTO dto){
        if (dto == null){
            return null;
        }
        Memory entity = new Memory();

        entity.setMemoryId(dto.getMemoryId());
        entity.setTitle(dto.getTitle());
        entity.setEventDate(dto.getEventDate());
        entity.setCreatedAt(dto.getCreatedAt());

        if(dto.getImageDTO() != null){
            Image image = new Image();
            image = ImageMapper.toEntity(dto.getImageDTO());
            entity.setImage(image);
        }

        return entity;
    }
    public static MemoryDTO toDTO(Memory entity){
        if(entity == null){
            return null;
        }
        MemoryDTO dto = new MemoryDTO();

        dto.setMemoryId(entity.getMemoryId());
        dto.setTitle(entity.getTitle());
        dto.setEventDate(entity.getEventDate());
        dto.setCreatedAt(entity.getCreatedAt());

        if(entity.getImage() != null){
            ImageDTO image = new ImageDTO();
            image = ImageMapper.toDTO(entity.getImage());
            dto.setImageDTO(image);
        }
        return dto;
    }
}
