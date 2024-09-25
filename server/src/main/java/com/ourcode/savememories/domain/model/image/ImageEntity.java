package com.ourcode.savememories.domain.model.image;

import com.ourcode.savememories.domain.model.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@Table(schema = "dbo", name = "Image")
public class ImageEntity extends BaseEntity{

    @Column(name = "Name")
    private String name;
    @Column(name = "Path")
    private String path;
    @Column(name = "Type")
    private String type;

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
}
