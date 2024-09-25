package com.ourcode.savememories.domain.model.memory;

import com.ourcode.savememories.domain.model.image.ImageDTO;
import com.ourcode.savememories.domain.model.image.ImageEntity;
import com.ourcode.savememories.domain.model.image.ImageMapper;

public class MemoryMapper {
    public static MemoryEntity toEntity(MemoryDTO dto){
        if (dto == null){
            return null;
        }
        MemoryEntity entity = new MemoryEntity();

        entity.setId(dto.getMemoryId());
        entity.setTitle(dto.getTitle());
        entity.setEventDate(dto.getEventDate());
        entity.setCreateAt(dto.getCreatedAt());

        if(dto.getImageDTO() != null){
            ImageEntity image = new ImageEntity();
            image = ImageMapper.toEntity(dto.getImageDTO());
            entity.setImage(image);
        }

        return entity;
    }
    public static MemoryDTO toDTO(MemoryEntity entity){
        if(entity == null){
            return null;
        }
        MemoryDTO dto = new MemoryDTO();

        dto.setMemoryId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setEventDate(entity.getEventDate());
        dto.setCreatedAt(entity.getCreateAt());

        if(entity.getImage() != null){
            ImageDTO image = new ImageDTO();
            image = ImageMapper.toDTO(entity.getImage());
            dto.setImageDTO(image);
        }
        return dto;
    }
}
