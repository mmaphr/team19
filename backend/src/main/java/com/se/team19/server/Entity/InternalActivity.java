package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table
public class InternalActivity {
    @Id
    @GeneratedValue(generator = "InternalActivity_Seq")
    private @NonNull Long actI;
    private @NonNull String actName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "dayId")
    private DaysOfTheWeek day;

    @ManyToOne
    @JoinColumn(name = "timeId")
    private TimeDuration time;

    public InternalActivity(@NonNull String actName, String description, Staff staff, DaysOfTheWeek day, TimeDuration time) {
        this.actName = actName;
        this.description = description;
        this.staff = staff;
        this.day = day;
        this.time = time;
    }
}