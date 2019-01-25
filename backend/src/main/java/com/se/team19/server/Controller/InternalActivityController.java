package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @PostMapping("/internalActivity/add/{actName}/{description}/{staffId}/{dayId}/{timeId}")
    public InternalActivity newInAct(InternalActivity newInAct, @PathVariable String actName, @PathVariable String description,
                                     @PathVariable Long staffId, @PathVariable Long dayId, @PathVariable Long timeId) {

        newInAct.setActName(actName);
        newInAct.setDescription(description);
        newInAct.setStaff(staffRepository.findById(staffId).get());
        newInAct.setDay(daysOfTheWeekRepository.findById(dayId).get());
        newInAct.setTime(timeDurationRepository.findById(timeId).get());

        return internalActivityRepository.save(newInAct);
    }

    @GetMapping("/daysOfTheWeek/getAll")
    public Collection<DaysOfTheWeek> getDaysOfTheWeek() {
        return daysOfTheWeekRepository.findAll();
    }

    @GetMapping("/timeDuration/getAll")
    public Collection<TimeDuration> getTimeDuration() {
        return timeDurationRepository.findAll();
    }

    @GetMapping("/staff/getAll")
    public Collection<Staff> getStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/internalActivity/getAll")
    public Collection<InternalActivity> getInternalActivity() {
        return internalActivityRepository.getAll();
    }

}

