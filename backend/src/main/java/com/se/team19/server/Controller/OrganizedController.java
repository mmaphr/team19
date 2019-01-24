package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrganizedController {
    @Autowired
    private OrganizedRepository organizedRepository;


    @GetMapping("/Organized")
    public Collection<Organized> getOrganized() {
        return organizedRepository.findAll().stream().collect(Collectors.toList());
    }


}
