package com.ourcode.ljwm.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "dbo",name = "images")
public class ImageEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "path")
    private String path;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
