package com.isdb.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MultiModuleController() {

    @GetMapping
    fun hello(): ResponseEntity<String> {
        return ResponseEntity.ok("Welcome to multi module gradle world")
    }
}