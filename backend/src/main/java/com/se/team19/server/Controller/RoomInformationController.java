package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class RoomInformationController {
    @Autowired
    private RoomInformationRepository roomInformationRepository;
    @Autowired
    private RoomStatusRepository roomStatusRepository;
    @Autowired
    private TypeRoomRepository typeRoomRepository;
    @Autowired
    private DataOlderRepository olderDataRepository;

    public RoomInformationController(RoomInformationRepository roomInformationRepository,
                                     RoomStatusRepository roomStatusRepository,
                                     TypeRoomRepository typeRoomRepository,
                                     DataOlderRepository olderDataRepository) {
        this.roomInformationRepository = roomInformationRepository;
        this.roomStatusRepository = roomStatusRepository;
        this.typeRoomRepository = typeRoomRepository;
        this.olderDataRepository = olderDataRepository;


    }

    @GetMapping("/Room")
    public Collection<RoomInformation> roomImformation() {
        return roomInformationRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Older/{name}")
    public DataOlder older(@PathVariable String name) {
        return olderDataRepository.findByOldername(name);
    }

    @GetMapping("/OldersName")
    public Collection<DataOlder> olders() {
        return olderDataRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/TypeRooms")
    public List<TypeRoom> Meeting() {
        return typeRoomRepository.findAll().stream().collect(Collectors.toList());

    }
    @GetMapping("/getRoomNumber/{roomnum}")
    public RoomInformation getRoom(@PathVariable String roomnum) throws Exception{

        return roomInformationRepository.findByRoomnumber(roomnum);

    }
    @GetMapping("/getOlder1OfRoom/{older1}")
    public RoomInformation getOlder1(@PathVariable String older1) throws Exception{
        if(roomInformationRepository.findByOlder(olderDataRepository.findByOldername(older1))==null)
            throw new Exception("ไม่เจอในห้องพัก");
        return roomInformationRepository.findByOlder(olderDataRepository.findByOldername(older1));

    }


    @PutMapping("/updateRoom1/{roomID}/{olderID}/{statusID}/{typeID}")
    RoomInformation update1(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID,
                            @PathVariable int typeID ) throws Exception{
        if(roomInformationRepository.findByOlder(olderDataRepository.findById(olderID).get())!=null)
            throw new Exception("เพิ่มไม่สำเร็จ ผู้สูงอายุมีห้องพักแล้ว");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==2)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==4)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==1)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==3)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                            update.setDayCheckin(new Date());
                            update.setOlder(olderDataRepository.findById(olderID).get());
                            update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                            return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }


    @PutMapping("/deleteRoom1/{roomID}/{olderID}/{statusID}")
    RoomInformation delete1(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID ){

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                            update.setOlder(null);
                            update.setDayCheckin(null);
                            update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                            return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }




    @PostMapping("/newRoom/{build}/{floor}/{roomNum}/{phone}/{typeRoom}")
    public RoomInformation newRoom(@RequestBody RoomInformation roomImformation,
                                   @PathVariable String roomNum,@PathVariable String build,@PathVariable int floor,@PathVariable String phone,
                                   @PathVariable long typeRoom) throws Exception{
        if(roomInformationRepository.findByRoomnumber(roomNum)!=null)
            throw new Exception("หมายเลขห้องพักซ้ำ!!");

        roomImformation.setBuilding(build);
        roomImformation.setFloor(floor);
        roomImformation.setRoomnumber(roomNum);
        roomImformation.setRoomphone(phone);
        roomImformation.setDayCheckin(null);
        roomImformation.setTyperoom(typeRoomRepository.findById(typeRoom));
        roomImformation.setRoomstatus(roomStatusRepository.findById(1));
        roomImformation.setOlder(null);

        return roomInformationRepository.save(roomImformation);
    }





}
