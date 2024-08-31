package com.ourcode.savememories.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ourcode.savememories.model.memory.Memory;

@Repository
public interface MemoryRepository extends JpaRepository<Memory,UUID>{
}
