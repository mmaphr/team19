package com.se.team19.server.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dayId", "timeId"})
})
public class InternalActivity {
    @Id
    @GeneratedValue(generator = "InternalActivity_Seq")
    private @NotNull Long actId;
    @Pattern(regexp = "[A-Za-zก-์' ']{5,30}")
    private @NotNull String actName;
    @Size(max = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private @NotNull Staff staff;

    @ManyToOne
    @JoinColumn(name = "dayId")
    private @NotNull DaysOfTheWeek day;

    @ManyToOne
    @JoinColumn(name = "timeId")
    private @NotNull TimeDuration time;

    public InternalActivity() {
    }

    public InternalActivity(String actName, String description, Staff staff, DaysOfTheWeek day, TimeDuration time) {
        this.actName = actName;
        this.description = description;
        this.staff = staff;
        this.day = day;
        this.time = time;
    }

}
