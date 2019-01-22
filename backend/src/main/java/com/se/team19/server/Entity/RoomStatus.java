package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Getter @Setter

@ToString
@EqualsAndHashCode
@Table(name="RoomStatus")
public class RoomStatus {
    @Id
    @SequenceGenerator(name="roomstatus_seq",sequenceName="roomstatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roomstatus_seq")
    @Column(name="ROOMSTATUS_ID",unique = true, nullable = true)
    private @NonNull Long Id;
    private @NonNull String Statusname;


    public RoomStatus() {}
    public RoomStatus(String Statusname) {
        this.Statusname = Statusname;
    }

}
