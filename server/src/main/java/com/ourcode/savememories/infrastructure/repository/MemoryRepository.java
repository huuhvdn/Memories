package com.ourcode.savememories.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourcode.savememories.domain.model.memory.MemoryEntity;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryEntity,UUID>{
}
