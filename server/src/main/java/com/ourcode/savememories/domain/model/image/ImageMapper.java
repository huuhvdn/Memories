package com.ourcode.savememories.domain.model.image;

public class ImageMapper {
    public static ImageEntity toEntity(ImageDTO dto){
        if(dto == null){
            return null;
        }
        ImageEntity entity = new ImageEntity();

        entity.setId(dto.getImageId());
        entity.setName(dto.getName());
        entity.setPath(dto.getPath());
        entity.setType(dto.getType());
        entity.setCreateAt(dto.getCreateAt());

        return entity;
    }
    public static ImageDTO toDTO(ImageEntity entity){
        if(entity == null){
            return null;
        }
        ImageDTO dto = new ImageDTO();

        dto.setImageId(entity.getId());
        dto.setName(entity.getName());
        dto.setPath(entity.getPath());
        dto.setType(entity.getType());
        dto.setCreateAt(entity.getCreateAt());

        return dto;
    }
}
