package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class DaysOfTheWeek {
    @Id
    @GeneratedValue(generator="DaysOfTheWeek_Seq")
    private @NonNull Long dayId;
    private @NonNull String dayName;

    public DaysOfTheWeek(@NonNull String dayName) {
        this.dayName = dayName;
    }
}

