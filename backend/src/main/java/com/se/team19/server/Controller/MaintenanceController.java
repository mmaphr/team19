package com.se.team19.server.Controller;

import com.se.team19.server.Entity.Maintenance;
import com.se.team19.server.Entity.MaintenanceStatus;
import com.se.team19.server.Entity.Place;
import com.se.team19.server.Repository.MaintenanceRepository;
import com.se.team19.server.Repository.MaintenanceStatusRepository;
import com.se.team19.server.Repository.PlaceRepository;
import com.se.team19.server.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MaintenanceController {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private MaintenanceStatusRepository maintenanceStatusRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @PostMapping("/maintenance/add/{maintenanceName}/{placeId}/{description}/{dateStart}/{timeStart}/{staffId}")
    public Maintenance newMaintenance(Maintenance newMaintenance, @PathVariable String maintenanceName,
                                      @PathVariable Long placeId, @PathVariable String description, @PathVariable Date dateStart,
                                      @PathVariable Date timeStart, @PathVariable Long staffId) {

        newMaintenance.setMaintenanceName(maintenanceName);
        newMaintenance.setDescription(description);
        newMaintenance.setDateStart(dateStart);
        newMaintenance.setTimeStart(timeStart);
        newMaintenance.setStaff(staffRepository.findById(staffId).get());
        newMaintenance.setPlace(placeRepository.findById(placeId).get());
        newMaintenance.setStatus(maintenanceStatusRepository.findById(1));

        return maintenanceRepository.save(newMaintenance);
    }

    @GetMapping("/place/getAll")
    public Collection<Place> getPlace() {
        return placeRepository.findAll();
    }

    @GetMapping("/maintenanceStatus/getAll")
    public Collection<MaintenanceStatus> getStatus() {
        return maintenanceStatusRepository.findAll();
    }

    @GetMapping("/maintenance/getStart")
    public Collection<Maintenance> getStart() {
        return maintenanceRepository.findAllByStatusOrderByDateStartAsc(maintenanceStatusRepository.findById(1));
    }

    @GetMapping("/maintenance/getFinish")
    public Collection<Maintenance> getFinish() {
        return maintenanceRepository.findAllByStatusOrderByDateFinishDesc(maintenanceStatusRepository.findById(2));
    }

    @PutMapping("/maintenance/update/{maintenanceId}")
    public Maintenance update(Maintenance maintenance, @PathVariable Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId).map(update -> {
            update.setDateFinish(new Date());
            update.setTimeFinish(new Date());
            update.setStatus(maintenanceStatusRepository.findById(2));
            return maintenanceRepository.save(update);
        }).orElseGet(() -> {
            maintenance.setMaintenanceId(maintenanceId);
            return maintenanceRepository.save(maintenance);
        });
    }

}
