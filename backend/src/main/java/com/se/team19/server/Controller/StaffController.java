package com.se.team19.server.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {

    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    public StaffController(GenderRepository genderRepository, PositionRepository positionRepository, ProvinceRepository provinceRepository, StaffRepository staffRepository) {
        this.genderRepository = genderRepository;
        this.positionRepository = positionRepository;
        this.provinceRepository = provinceRepository;
        this.staffRepository = staffRepository;
    }

    @GetMapping("/Staff")
    public  Collection<Staff> Staff(){
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Staff/{staffID}")
    public  Optional<Staff> Staff(@PathVariable Long staffID){
        return staffRepository.findById(staffID);
    }

    @GetMapping("/Gender")
    public  Collection<Gender> Gender(){
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Gender/{genderID}")
    public  Optional<Gender> Gender(@PathVariable Long genderID){
        return genderRepository.findById(genderID);
    }

    @GetMapping("/Position")
    public  Collection<Position> Position(){
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Position/{positionID}")
    public  Optional<Position> Position(@PathVariable Long positionID){
        return positionRepository.findById(positionID);
    }

    @GetMapping("/Province")
    public  Collection<Province> Province(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Province/{provinceID}")
    public  Optional<Province> Province(@PathVariable Long provinceID){
        return provinceRepository.findById(provinceID);
    }

    @PostMapping("/newStaff/{genderID}/{provinceID}/{positionID}/{staffAge}")
    public Staff newStaff(@PathVariable long genderID,
                          @PathVariable long provinceID,
                          @PathVariable long positionID,
                          @PathVariable int staffAge,
                          @RequestBody String dataStaff) throws IOException {
        final String decoded = URLDecoder.decode(dataStaff, "UTF-8");
        dataStaff = decoded;

        Staff newStaff = new Staff();

        if(dataStaff.charAt(0) == '{') {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataStaff);
            newStaff.setStaffName(actualObj.get("staffName").textValue());
            newStaff.setAddress(actualObj.get("address").textValue());
            newStaff.setPhone(actualObj.get("phone").textValue());
            newStaff.setUsername(actualObj.get("username").textValue());
            newStaff.setPassword(actualObj.get("password").textValue());
        }
        newStaff.setStaffGender(genderRepository.findById(genderID));
        newStaff.setStaffProvince(provinceRepository.findById(provinceID));
        newStaff.setStaffPosition(positionRepository.findById(positionID));
        newStaff.setAge(staffAge);

        return staffRepository.save(newStaff);
    }
}
