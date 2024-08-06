package com.ourcode.memories.domain.service.image;

import com.ourcode.memories.domain.entity.Image;

public class ImageMapper {
    public static ImageDTO toDTO(Image entity){
        if(entity == null){
            return null;
        }
        ImageDTO dto = new ImageDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setPath(entity.getPath());
        dto.setUploadTime(entity.getUploadTime());
        return dto;
    }
    public static Image toEntity(ImageDTO dto){
        if (dto == null){
            return null;
        }

        Image entity = new Image();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setPath(dto.getPath());
        entity.setUploadTime(dto.getUploadTime());

        return entity;
    }
}
