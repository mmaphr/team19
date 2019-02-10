package com.se.team19.server.Controller;

import com.se.team19.server.Entity.PlaceTy;
import com.se.team19.server.Repository.PlaceTyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlaceTyController {
    @Autowired
    private PlaceTyRepository placeTyRepository;

    @GetMapping("/Place")
    public Collection<PlaceTy> getOutActivity() {
        return placeTyRepository.findAll().stream().collect(Collectors.toList());
    }

}
