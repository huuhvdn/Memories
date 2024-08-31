package com.ourcode.savememories.model.memory;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ourcode.savememories.model.image.ImageDTO;

public class MemoryDTO {
    private UUID memoryId;
    private String title;
    private LocalDateTime eventDate;
    private LocalDateTime createAt;
    private ImageDTO imageDTO;

    
    public MemoryDTO() {
    }
    public MemoryDTO(UUID memoryId, String title, LocalDateTime eventDate, LocalDateTime createAt, ImageDTO imageDTO) {
        this.memoryId = memoryId;
        this.title = title;
        this.eventDate = eventDate;
        this.createAt = createAt;
        this.imageDTO = imageDTO;
    }

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
    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public ImageDTO getImageDTO() {
        return imageDTO;
    }
    public void setImageDTO(ImageDTO imageDTO) {
        this.imageDTO = imageDTO;
    }
}
