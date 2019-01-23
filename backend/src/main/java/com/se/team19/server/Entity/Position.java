package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "position")
public class Position {
    @Id
    @SequenceGenerator(name="position_seq",sequenceName="position_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="position_seq")
    @Column(name="POSITION_ID",unique = true, nullable = false)
    private @NonNull Long PositionId;
    private @NonNull String PositionName;

    public Position() {}

    public Position(String positionName) {
        PositionName = positionName;
    }
}
