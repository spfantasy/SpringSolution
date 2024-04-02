package com.yorha.adhoc.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.yorha.swift.example.SimpleExample;

@RestController
public class ProwideCoreController {

    @GetMapping("/MT202SortTagsExample")
    public ResponseEntity<String> MT202SortTagsExample() {
        return new ResponseEntity<>(SimpleExample.test(), HttpStatus.OK);
    }
}
