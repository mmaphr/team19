package com.se.team19.server.Controller;

import com.se.team19.server.Entity.InternalActivity;
import com.se.team19.server.Repository.DaysOfTheWeekRepository;
import com.se.team19.server.Repository.InternalActivityRepository;
import com.se.team19.server.Repository.StaffRepository;
import com.se.team19.server.Repository.TimeDurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InternalActivityController {

    @Autowired
    private DaysOfTheWeekRepository daysOfTheWeekRepository;
    @Autowired
    private InternalActivityRepository internalActivityRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TimeDurationRepository timeDurationRepository;

    @PostMapping("/internalActivity/Add/{actName}/{description}/{staffId}/{dayId}/{timeId}")
    public InternalActivity newInAct(InternalActivity newInAct, @PathVariable String actName, @PathVariable String description,
                                     @PathVariable Long staffId, @PathVariable Long dayId, @PathVariable Long timeId) {

        newInAct.setActName(actName);
        newInAct.setDescription(description);
        newInAct.setStaff(staffRepository.findById(staffId).get());
        newInAct.setDay(daysOfTheWeekRepository.findById(dayId).get());
        newInAct.setTime(timeDurationRepository.findById(timeId).get());

        return internalActivityRepository.save(newInAct);
    }

}

