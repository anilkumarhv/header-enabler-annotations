package com.anil.enablerannotation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Common Header Enabler Annotation Example!!!");
    }
}
