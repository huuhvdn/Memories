package com.ourcode.savememories.domain.model.memory;

import java.time.LocalDateTime;

import com.ourcode.savememories.domain.model.BaseEntity;
import com.ourcode.savememories.domain.model.image.ImageEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dto", name = "Memories")
public class MemoryEntity extends BaseEntity {
    
    @Column(name ="Title")
    private String title;
    @Column(name = "EventDate")
    private LocalDateTime eventDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ImageId")
    private ImageEntity image;
    
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
    public ImageEntity getImage() {
        return image;
    }
    public void setImage(ImageEntity image) {
        this.image = image;
    }
}
