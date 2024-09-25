package com.ourcode.savememories.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourcode.savememories.domain.model.image.ImageEntity;

@Repository
public interface ImageRepository  extends JpaRepository<ImageEntity,UUID>{ 
}
