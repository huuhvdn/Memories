package com.ourcode.memories.domain.service.image;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ImageDTO {
    private Long id;
    private String name;
    private String path;
    private String type;
    private LocalDateTime uploadTime;
}
