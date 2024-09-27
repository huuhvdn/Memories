package com.ourcode.ljwm.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourcode.ljwm.domain.entities.MemoryEntity;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryEntity,UUID>{
    
}
