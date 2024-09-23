package com.ourcode.savememories.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dbo", name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ImageId")
    private UUID imageId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Path")
    private String path;
    @Column(name = "Type")
    private String type;
    @Column(name = "CreateAt")
    private LocalDateTime createAt;
    
    public Image() {
    }
    public Image(UUID imageId, String name, String path, String type, LocalDateTime createAt) {
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
