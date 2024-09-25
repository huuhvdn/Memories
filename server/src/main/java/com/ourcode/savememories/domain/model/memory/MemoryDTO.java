package com.ourcode.savememories.domain.model.memory;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ourcode.savememories.domain.model.image.ImageDTO;

public class MemoryDTO {
    private UUID memoryId;
    private String title;
    private LocalDateTime eventDate;
    private LocalDateTime createdAt;
    private ImageDTO imageDTO;

    

    public UUID getMemoryId() {
        return memoryId;
    }
    public void setMemoryId(UUID memoryId) {
        this.memoryId = memoryId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public ImageDTO getImageDTO() {
        return imageDTO;
    }
    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }
}
