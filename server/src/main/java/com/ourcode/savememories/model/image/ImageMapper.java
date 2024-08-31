package com.ourcode.savememories.model.image;

public class ImageMapper {
    public static Image toEntity(ImageDTO dto){
        if(dto == null){
            return null;
        }
        Image entity = new Image();

        entity.setImageId(dto.getImageId());
        entity.setName(dto.getName());
        entity.setPath(dto.getPath());
        entity.setType(dto.getType());
        entity.setCreateAt(dto.getCreateAt());

        return entity;
    }
    public static ImageDTO toDTO(Image entity){
        if(entity == null){
            return null;
        }
        ImageDTO dto = new ImageDTO();

        dto.setImageId(entity.getImageId());
        dto.setName(entity.getName());
        dto.setPath(entity.getPath());
        dto.setType(entity.getType());
        dto.setCreateAt(entity.getCreateAt());

        return dto;
    }
}
