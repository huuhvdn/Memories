package com.ourcode.memories.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ourcode.memories.domain.entity.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
    
}
