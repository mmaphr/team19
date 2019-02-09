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
public class HealthCheckController {
    @Autowired
    private DataOlderRepository dataOlderRepository;
    @Autowired
    private HealthCheckRepository healthCheckRepository;
    @Autowired
    private TypeHealthCheckRepository typeHealthCheckRepository;

    public HealthCheckController(DataOlderRepository dataOlderRepository,HealthCheckRepository healthCheckRepository,
                                 TypeHealthCheckRepository typeHealthCheckRepository) {
        this.dataOlderRepository = dataOlderRepository;
        this.healthCheckRepository = healthCheckRepository;
        this.typeHealthCheckRepository = typeHealthCheckRepository;
    }


    @PostMapping("/AddHealthCheck/{datecheck}/{healthCheckType}/{dataOlderId}")
    public HealthCheck newHealthCheck(@PathVariable Date datecheck,@PathVariable long healthCheckType,
                                  @PathVariable long dataOlderId, @RequestBody String healthCheck)throws IOException {
        final String decoded = URLDecoder.decode(healthCheck, "UTF-8");
        healthCheck = decoded;

        HealthCheck newhealthCheck = new HealthCheck();

        if(healthCheck.charAt(0) == '{'){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(healthCheck);
            newhealthCheck.setHospital(actualObj.get("hospital").textValue());
            newhealthCheck.setExpenses( Integer.valueOf(actualObj.get("expenses").textValue()));
            newhealthCheck.setDescription( actualObj.get("description").textValue());
        }
        newhealthCheck.setDatecheck(datecheck);
        newhealthCheck.setHealthCheckType(typeHealthCheckRepository.findById(healthCheckType));
        newhealthCheck.setHealthCheckData(dataOlderRepository.findById(dataOlderId));

        System.out.println(newhealthCheck);
        healthCheckRepository.save(newhealthCheck);

        return newhealthCheck;
    }

    @GetMapping("/HealthCheckType")
    public Collection<TypeHealthCheck> TypeHealthCheck() {
        return typeHealthCheckRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/HealthCheck/{DataOlderId}")
    public Collection<HealthCheck> HealthCheck(@PathVariable long DataOlderId) {
        return healthCheckRepository.findByHealthCheckData(dataOlderRepository.findById(DataOlderId));
    }
}
