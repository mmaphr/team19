package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Data
@Entity
@Getter @Setter

@ToString
@EqualsAndHashCode
@Table(name="ROOM_INFORMATION")
public class RoomInformation {
    @Id
    @SequenceGenerator(name="room_seq",sequenceName="room_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_seq")
    @Column(name="room_ID",unique = true, nullable = true)
    private @NotNull Long Id;

    @NotNull
    @Pattern(regexp = "^[A-z][0-9]{3}$")
    @Column(unique = true)
    private String roomnumber;

    @NotNull
    @Pattern(regexp = "^([A-z*0-9*ก-๙*' '])*")
    private String building;

    @NotNull
    private @Min(value = 1) int floor;

    @NotNull
    @Pattern(regexp = "^[0][0-9]{5}$")
    @Column(unique = true)
    private String roomphone;

    @Temporal(TemporalType.DATE)
    private Date dayCheckin;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROOMSTATUS_ID", nullable = true)
    private RoomStatus Roomstatus;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = true)
    private TypeRoom Typeroom;


    @OneToOne
    @JoinColumn(name = "OLDER_NAME", nullable = true)
    private DataOlder older;



    public RoomInformation() {}
    public RoomInformation(String RoomNumber,RoomStatus RoomStatus,TypeRoom TypeRoom,DataOlder older,String building,int floor,String roomphone,Date dayCheckin) {
        this.roomnumber = RoomNumber;
        this.Roomstatus = RoomStatus;
        this.Typeroom = TypeRoom;
        this.older = older;
        this.building = building;
        this.floor = floor;
        this.roomphone = roomphone;
        this.dayCheckin = dayCheckin;

    }
}
