package com.ourcode.ljwm.domain.mappers;

import com.ourcode.ljwm.domain.dtos.ImageDTO;
import com.ourcode.ljwm.domain.dtos.MemoryDTO;
import com.ourcode.ljwm.domain.entities.ImageEntity;
import com.ourcode.ljwm.domain.entities.MemoryEntity;

public class MemoryMapper {
    public static MemoryEntity toEntity(MemoryDTO dto){
        if(dto == null){
            return null;
        }

        MemoryEntity entity = new MemoryEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setLocation(dto.getLocation());
        entity.setEventDate(dto.getEventDate());
        entity.setCreateAt(dto.getCreateAt());
        entity.setUpdateAt(dto.getUpdateAt());
        if(dto.getImageDTO() != null){
            ImageEntity image = ImageMapper.toEntity(dto.getImageDTO());
            entity.setImageEntity(image);
        }

        return entity;

    }
    public static MemoryDTO toDTO(MemoryEntity entity){
        if(entity == null){
            return null;
        }

        MemoryDTO dto = new MemoryDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setLocation(entity.getLocation());
        dto.setEventDate(entity.getEventDate());
        dto.setCreateAt(entity.getCreateAt());
        dto.setUpdateAt(entity.getUpdateAt());
        if(entity.getImageEntity() != null){
            ImageDTO image = ImageMapper.toDTO(entity.getImageEntity());
            dto.setImageDTO(image);
        }

        return dto;

    }
}
