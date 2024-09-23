package com.ourcode.savememories.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dto", name = "Memories")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="MemoryId")
    private UUID memoryId;
    @Column(name ="Title")
    private String title;
    @Column(name = "EventDate")
    private LocalDateTime eventDate;
    @Column(name ="CreatedAt")
    private LocalDateTime createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ImageId")
    private Image image;

    
    public Memory() {
    }
    public Memory(UUID memoryId, String title, LocalDateTime eventDate, LocalDateTime createdAt, Image image) {
        this.memoryId = memoryId;
        this.title = title;
        this.eventDate = eventDate;
        this.createdAt = createdAt;
        this.image = image;
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
}
