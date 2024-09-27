package com.ourcode.ljwm.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public class MemoryDTO {
    private UUID id;
    private String title;
    private String location;
    private LocalDateTime eventDate;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private ImageDTO imageDTO;
    public ImageDTO getImageDTO() {
        return imageDTO;
    }
    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
