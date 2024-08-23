package com.yorha.adhoc.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.yorha.swift.example.MessageCreation3Example;

@RestController
public class ProwideCoreController {

    @GetMapping("/MT202SortTagsExample")
    public ResponseEntity<String> MT202SortTagsExample() {
        String[] params = {"1"};
        MessageCreation3Example.main(params);
        return new ResponseEntity<>("done", HttpStatus.OK);
    }
}
