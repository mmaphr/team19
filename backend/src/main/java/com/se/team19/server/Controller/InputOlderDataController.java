package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InputOlderDataController {
    @Autowired
    private DataOlderRepository dataOlderRepository;
    @Autowired
    private OlderDiseaseRepository olderDiseaseRepository ;
    @Autowired
    private GenderRepository genderRepository ;
    @Autowired
    private OlderDataAndDiseaseRepository olderDataAndDiseaseRepository ;
    @Autowired
    private ProvinceRepository provinceRepository ;

    public InputOlderDataController(DataOlderRepository dataOlderRepository ,OlderDiseaseRepository olderDiseaseRepository,
                                GenderRepository genderRepository,OlderDataAndDiseaseRepository olderDataAndDiseaseRepository,
                                ProvinceRepository provinceRepository) {
        this.dataOlderRepository = dataOlderRepository;
        this.olderDiseaseRepository = olderDiseaseRepository;
        this.olderDataAndDiseaseRepository = olderDataAndDiseaseRepository;
        this.provinceRepository = provinceRepository;
        this.genderRepository = genderRepository;
    }



    @PostMapping("/AddDataOlder/{olderbirth}/{oldergender}/{olderdisease}/{parentprovince}")
    public DataOlder newDataOlder(@PathVariable Date olderbirth,@PathVariable long oldergender,
                                  @PathVariable long[] olderdisease,@PathVariable long parentprovince,
                                  @RequestBody String dataOlder)throws IOException {
        final String decoded = URLDecoder.decode(dataOlder, "UTF-8");
        dataOlder = decoded;

        DataOlder newOlder = new DataOlder();

        if(dataOlder.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataOlder);
            newOlder.setOldername( actualObj.get("oldername").textValue());
            newOlder.setParentname(actualObj.get("parentname").textValue());
            newOlder.setParentaddress( actualObj.get("parentaddress").textValue());
            newOlder.setParentphone( actualObj.get("parentphone").textValue());
        }
        newOlder.setOlderbirth(olderbirth);
        newOlder.setDataOlderGender(genderRepository.findById(oldergender));
        newOlder.setDataOlderProvince(provinceRepository.findById(parentprovince));

        System.out.println(newOlder);
        dataOlderRepository.save(newOlder);

        for(int i = 0 ; i<(int)olderdisease.length ; i++) {
            OlderDataAndDisease newODAD = new OlderDataAndDisease();
            newODAD.setDataOlderAndDiseaseDataOlder(dataOlderRepository.findById(dataOlderRepository.count()));
            newODAD.setDataOlderAndDiseaseOlderDisease(olderDiseaseRepository.findById(olderdisease[i]));
            olderDataAndDiseaseRepository.save(newODAD);
            System.out.println(newODAD);
        }
        return newOlder;
    }







    @GetMapping("/DataOlderAll")
    public Collection<DataOlder> DataOlder() {
        return dataOlderRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/OlderDisease")
    public Collection<OlderDisease> OlderDisease() {
        return olderDiseaseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Gender")
    public Collection<Gender> Gender() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OlderDataAndDisease")
    public Collection<OlderDataAndDisease> OlderDataAndDisease() {
        return olderDataAndDiseaseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Province")
    public Collection<Province> Province() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
}
