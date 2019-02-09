package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainStaffController {

    @Autowired
    private TrainTypeRepository trainTypeRepository;
    @Autowired
    private TrainStaffRepository trainStaffRepository;
    @Autowired
    private TrainAndStaffRepository trainAndStaffRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TimeDurationRepository timeDurationRepository;

    public TrainStaffController(TrainTypeRepository trainTypeRepository,
                                TrainStaffRepository trainStaffRepository,
                                TrainAndStaffRepository trainAndStaffRepository,
                                StaffRepository staffRepository,
                                TimeDurationRepository timeDurationRepository) {
        this.trainTypeRepository = trainTypeRepository;
        this.trainStaffRepository = trainStaffRepository;
        this.trainAndStaffRepository = trainAndStaffRepository;
        this.staffRepository = staffRepository;
        this.timeDurationRepository = timeDurationRepository;
    }

    @Autowired


    @GetMapping("/TrainStaff")
    public  Collection<TrainStaff> TrainStaff(){
        return trainStaffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/TrainStaff/{trainID}")
    public  Optional<TrainStaff> TrainStaff(@PathVariable Long trainID){
        return trainStaffRepository.findById(trainID);
    }

    @GetMapping("/TrainType")
    public  Collection<TrainType> TrainType(){
        return trainTypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/TrainType/{traintypeID}")
    public  Optional<TrainType> TrainType(@PathVariable Long traintypeID){
        return trainTypeRepository.findById(traintypeID);
    }

    @GetMapping("/TrainAndStaff")
    public  Collection<TrainAndStaff> TrainAndStaff(){
        return trainAndStaffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/TrainAndStaff/{trainandstaffID}")
    public  Optional<TrainAndStaff> TrainAndStaff(@PathVariable Long trainandstaffID){
        return trainAndStaffRepository.findById(trainandstaffID);
    }

    @PostMapping("/newTrain/{trainName}/{trainDescription}/{timeId}/{traintypeID}/{staffID}/{trainDate}")
    public TrainStaff newTrain(TrainStaff newTrain,
                               @PathVariable String trainName,
                               @PathVariable String trainDescription,
                               @PathVariable long timeId,
                               @PathVariable long traintypeID,
                               @PathVariable long staffID,
                               @PathVariable Date trainDate){

        newTrain.setTrainName(trainName);
        newTrain.setTrainDescription(trainDescription);
		newTrain.setTrainTime(timeDurationRepository.findById(timeId));
		newTrain.setTrainType(trainTypeRepository.findById(traintypeID));
		newTrain.setTrainStaff(staffRepository.findById(staffID));
        newTrain.setTrainDate(trainDate);

        return trainStaffRepository.save(newTrain);
    }

    @PostMapping("/Training/{trainID}/{staffID}")
    public TrainAndStaff newTraining(TrainAndStaff newTraining,
                               @PathVariable long trainID,
                               @PathVariable long staffID){
        newTraining.setTrainAndStaffStaff(staffRepository.findById(staffID));
        newTraining.setTrainAndStaffTrainStaff(trainStaffRepository.findById(trainID));


        return trainAndStaffRepository.save(newTraining);
    }
}
