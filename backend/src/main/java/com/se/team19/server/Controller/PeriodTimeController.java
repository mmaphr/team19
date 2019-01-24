package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PeriodTimeController {
    @Autowired
    private PeriodTimeRepository periodTimeRepository;


    @GetMapping("/PeriodTime")
    public Collection<PeriodTime> getPeriodTime() {
        return periodTimeRepository.findAll().stream().collect(Collectors.toList());
    }


}
