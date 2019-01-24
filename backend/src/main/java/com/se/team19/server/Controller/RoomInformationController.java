package com.se.team19.server.Controller;

import com.se.team19.server.Entity.*;
import com.se.team19.server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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
        if(roomInformationRepository.findByOlder1(olderDataRepository.findByOldername(older1))==null&&
                roomInformationRepository.findByOlder2(olderDataRepository.findByOldername(older1))==null&&
                roomInformationRepository.findByOlder3(olderDataRepository.findByOldername(older1))==null)
            throw new Exception("ไม่เจอในห้องพัก");
        return roomInformationRepository.findByOlder1(olderDataRepository.findByOldername(older1));

    }
    @GetMapping("/getOlder2OfRoom/{older2}")
    public RoomInformation getOlder2(@PathVariable String older2) throws Exception{

        return roomInformationRepository.findByOlder2(olderDataRepository.findByOldername(older2));

    }
    @GetMapping("/getOlder3OfRoom/{older3}")
    public RoomInformation getOlder3(@PathVariable String older3) {
        return roomInformationRepository.findByOlder3(olderDataRepository.findByOldername(older3));

    }



    @PutMapping("/updateRoom1/{roomID}/{olderID}/{statusID}/{typeID}")
    RoomInformation update1(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID,
                            @PathVariable int typeID ) throws Exception{
        if(roomInformationRepository.findByOlder1(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder2(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder3(olderDataRepository.findById(olderID).get())!=null)
            throw new Exception("เพิ่มไม่สำเร็จ ผู้สูงอายุมีห้องพักแล้ว");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==2)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==4)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==1)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==3)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                    update.setOlder1(olderDataRepository.findById(olderID).get());
                    update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                    return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }
    @PutMapping("/updateRoom2/{roomID}/{olderID}/{statusID}/{typeID}")
    RoomInformation update2(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID,
                            @PathVariable int typeID) throws Exception{
        if(roomInformationRepository.findByOlder1(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder2(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder3(olderDataRepository.findById(olderID).get())!=null)
            throw new Exception("เพิ่มไม่สำเร็จ ผู้สูงอายุมีห้องพักแล้ว");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==2)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==4)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==1)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==3)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                    update.setOlder2(olderDataRepository.findById(olderID).get());
                    update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                    return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }
    @PutMapping("/updateRoom3/{roomID}/{olderID}/{statusID}/{typeID}")
    RoomInformation update3(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID,
                            @PathVariable int typeID) throws Exception{
        if(roomInformationRepository.findByOlder1(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder2(olderDataRepository.findById(olderID).get())!=null||
                roomInformationRepository.findByOlder3(olderDataRepository.findById(olderID).get())!=null)
            throw new Exception("เพิ่มไม่สำเร็จ ผู้สูงอายุมีห้องพักแล้ว");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==2)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="ชาย"&&typeID==4)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักชาย");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==1)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");
        if(olderDataRepository.findById(olderID).get().getDataOlderGender().getGenderName()=="หญิง"&&typeID==3)throw new Exception("ประเภทห้องไม่ถูกต้อง กรุณาเลือกห้องพักหญิง");

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                            update.setOlder3(olderDataRepository.findById(olderID).get());
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
                            update.setOlder1(null);
                            update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                            return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }
    @PutMapping("/deleteRoom2/{roomID}/{olderID}/{statusID}")
    RoomInformation delete2(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID){

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                            update.setOlder2(null);
                            update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                            return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }
    @PutMapping("/deleteRoom3/{roomID}/{olderID}/{statusID}")
    RoomInformation delete3(RoomInformation roomImformation,
                            @PathVariable Long roomID,
                            @PathVariable Long olderID,
                            @PathVariable Long statusID){

        return roomInformationRepository.findById(roomID)

                .map(update ->{
                            update.setOlder3(null);
                            update.setRoomstatus(roomStatusRepository.findById(statusID).get());

                            return roomInformationRepository.save(update);
                        }
                ).orElseGet(() ->{
                    roomImformation.setId(roomID);
                    return roomInformationRepository.save(roomImformation);
                });
    }




    @PostMapping("/newRoom/{roomNum}/{typeRoom}")
    public RoomInformation newRoom(@RequestBody RoomInformation roomImformation,
                                   @PathVariable String roomNum,
                                   @PathVariable long typeRoom) throws Exception{
        if(roomInformationRepository.findByRoomnumber(roomNum)!=null)
            throw new Exception("หมายเลขห้องพักซ้ำ!!");

        roomImformation.setRoomnumber(roomNum);
        roomImformation.setTyperoom(typeRoomRepository.findById(typeRoom));
        roomImformation.setRoomstatus(roomStatusRepository.findById(1));
        roomImformation.setOlder1(null);
        roomImformation.setOlder2(null);
        roomImformation.setOlder3(null);
        return roomInformationRepository.save(roomImformation);
    }





}
