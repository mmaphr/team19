package com.example.demo.controller;

import com.example.demo.repository.*;
import com.example.demo.entity.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OutActivityController {
    @Autowired
    private OutActivityRepository outActivityRepository;
    @Autowired
    private CategoryActivityRepository categoryActivityRepository;
    @Autowired
    private PeriodTimeRepository periodTimeRepository;
    @Autowired
    private OrganizedRepository organizedRepository;
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/OutActivity")
    public Collection<OutActivity> getOutActivity() {
        return outActivityRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path ="/outactivity/{category_id}/{organized_id}/{periodTimeS_id}/{periodTimeE_id}/{staffId}")
    public OutActivity  postOutActivity(@RequestBody OutActivity outActivity,
                                                  @PathVariable Long category_id,
                                                  @PathVariable Long organized_id,
                                                  @PathVariable Long periodTimeS_id,
                                                  @PathVariable Long periodTimeE_id,
                                                  @PathVariable Long staffId
                                                    )throws Exception {
            try{
                CategoryActivity category = categoryActivityRepository.findById(category_id).get();
                Organized organized = organizedRepository.findById(organized_id).get();
                PeriodTime periodTimeS = periodTimeRepository.findById(periodTimeS_id).get();
                PeriodTime periodTimeE = periodTimeRepository.findById(periodTimeE_id).get();
                Staff staff = staffRepository.findById(staffId).get();

                outActivity.setCategoryActivity(category);
                outActivity.setOrganized(organized);
                outActivity.setPeriodTimeS(periodTimeS);
                outActivity.setPeriodTimeE(periodTimeE);
                outActivity.setStaff(staff);



            }catch(Exception e){
                System.out.print(e);
                throw new Exception("ERROR");
            }
            return outActivityRepository.save(outActivity);
        }
}