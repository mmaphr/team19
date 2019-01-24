package com.example.demo.controller;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryActivityController {
    @Autowired
    private CategoryActivityRepository categoryActivityRepository;


    @GetMapping("/CategoryActivity")
    public Collection<CategoryActivity> getCategory() {
        return categoryActivityRepository.findAll().stream().collect(Collectors.toList());
    }


}
