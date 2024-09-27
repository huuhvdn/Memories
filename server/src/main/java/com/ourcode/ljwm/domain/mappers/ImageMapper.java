package com.ourcode.ljwm.domain.mappers;

import com.ourcode.ljwm.domain.dtos.ImageDTO;
import com.ourcode.ljwm.domain.entities.ImageEntity;

public class ImageMapper {
    public static ImageEntity toEntity(ImageDTO dto){
        if(dto == null){
            return null;
        }
    
        ImageEntity entity = new ImageEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setPath(dto.getPath());
        entity.setCreateAt(dto.getCreateAt());
        entity.setUpdateAt(dto.getUpdateAt());

        return entity;
    }
    public static ImageDTO toDTO(ImageEntity entity){
        if(entity == null){
            return null;
        }

        ImageDTO dto = new ImageDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setPath(entity.getPath());
        dto.setCreateAt(entity.getCreateAt());
        dto.setUpdateAt(entity.getUpdateAt());

        return dto;
    }
}
