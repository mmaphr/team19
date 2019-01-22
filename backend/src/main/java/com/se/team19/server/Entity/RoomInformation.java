package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
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
    private @NonNull Long Id;
    private @NonNull String roomnumber;

    @ManyToOne
    @JoinColumn(name = "ROOMSTATUS_ID", nullable = true)
    private RoomStatus Roomstatus;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = true)
    private TypeRoom Typeroom;

    @ManyToOne
    @JoinColumn(name = "OLDER1_NAME", nullable = true)
    private DataOlder older1;

    @ManyToOne
    @JoinColumn(name = "OLDER2_NAME", nullable = true)
    private DataOlder older2;

    @ManyToOne
    @JoinColumn(name = "OLDER3_NAME", nullable = true)
    private DataOlder older3;

    public RoomInformation() {}
    public RoomInformation(String RoomNumber,RoomStatus RoomStatus,TypeRoom TypeRoom,DataOlder older1,DataOlder older2,DataOlder older3) {
        this.roomnumber = RoomNumber;
        this.Roomstatus = RoomStatus;
        this.Typeroom = TypeRoom;
        this.older1 = older1;
        this.older2 = older2;
        this.older2 = older2;

    }
}