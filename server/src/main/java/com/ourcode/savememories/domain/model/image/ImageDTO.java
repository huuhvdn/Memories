package com.ourcode.savememories.domain.model.image;

import java.time.LocalDateTime;
import java.util.UUID;

public class ImageDTO {
    private UUID imageId;
    private String name;
    private String path;
    private String type;   
    private LocalDateTime createAt;

    public ImageDTO() {
    }
    public ImageDTO(UUID imageId, String name, String path, String type, LocalDateTime createAt) {
        this.imageId = imageId;
        this.name = name;
        this.path = path;
        this.type = type;
        this.createAt = createAt;
    }
    
    public UUID getImageId() {
        return imageId;
    }
    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
