package com.ourcode.savememories.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/health")
public class HealthController {
    @GetMapping
    public ResponseEntity<String> HealthCheck() {
        return ResponseEntity.ok("OK");
    }
}
