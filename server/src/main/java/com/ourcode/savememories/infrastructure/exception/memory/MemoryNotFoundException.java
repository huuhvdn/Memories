package com.ourcode.savememories.infrastructure.exception.memory;

import java.util.UUID;

public class MemoryNotFoundException extends RuntimeException {
    public MemoryNotFoundException(UUID id){
        super("Memory not found with id: "+ id);
    }
}
