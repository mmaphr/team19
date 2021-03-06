package com.se.team19.server.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class VisitorController {
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private RelativesStatusRepository relativesStatusRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private RoomInformationRepository roomInformationRepository;
    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private DataOlderRepository dataOlderRepository;


    public VisitorController(RoomInformationRepository roomInformationRepository,
                             GenderRepository genderRepository,
                             RelativesStatusRepository relativesStatusRepository,
                             ProvinceRepository provinceRepository,
                             VisitorRepository visitorRepository,
                             DataOlderRepository dataOlderRepository
    ) {
        this.roomInformationRepository = roomInformationRepository;
        this.genderRepository = genderRepository;
        this.relativesStatusRepository = relativesStatusRepository;
        this.provinceRepository = provinceRepository;
        this.visitorRepository = visitorRepository;
        this.dataOlderRepository = dataOlderRepository;


    }
    @GetMapping("/Visitor")
    public Collection<Visitor> getVistor() {
        return visitorRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/relativeStatus")
    public List<RelativesStatus> getStaus() {
        return relativesStatusRepository.findAll().stream().collect(Collectors.toList());

    }

    @GetMapping("/checkOlder1OfRoom/{older1}")
    public RoomInformation getOlder1(@PathVariable long older1) throws Exception{
        return roomInformationRepository.findByOlder(dataOlderRepository.findById(older1));

    }

    @PostMapping("/AddVisitor/{name}/{numid}/{gender}/{age}/{provice}/{phone}/{older}/{status}")
    public Visitor newVisitor(
            @PathVariable String name,
            @PathVariable String numid,
            @PathVariable long gender,
            @PathVariable int age,
            @PathVariable long provice,
            @PathVariable String phone,
            @PathVariable long older,
            @PathVariable long status,@RequestBody String inputData) throws Exception{
        if(roomInformationRepository.findByOlder(dataOlderRepository.findById(older))==null)
            throw new Exception("ไม่เจอผู้สูงอายุนี้ในห้องพัก");

        final String decoded = URLDecoder.decode(inputData, "UTF-8");
        inputData = decoded;

        Visitor visitor = new Visitor();

        if(inputData.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(inputData);
            visitor.setAddressVisitor( actualObj.get("address").textValue());
        }
        visitor.setNameVisitor(name);
        visitor.setNumIdVisitor(numid);
        visitor.setAgeVisitor(age);
        visitor.setPhoneVisitor(phone);
        visitor.setDayVisitor(new Date());
        visitor.setTimeVisitor(new Date());
        visitor.setGenders(genderRepository.findById(gender));
        visitor.setProvince(provinceRepository.findById(provice));
        visitor.setRelativesStatus(relativesStatusRepository.findById(status));
        visitor.setOlders(dataOlderRepository.findById(older));
        return visitorRepository.save(visitor);
    }



}
