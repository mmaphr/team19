package com.se.team19.server.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dateStart", "placeId"})
})
public class Maintenance {
    @Id
    @GeneratedValue(generator = "Maintenance_Seq")
    private @NotNull Long maintenanceId;
    @Pattern(regexp = "[A-Za-zก-์' ']{5,30}")
    private @NotNull String maintenanceName;
    @Size(max = 50)
    private @NotNull String description;
    @Temporal(TemporalType.DATE)
    private @NotNull Date dateStart;
    @Temporal(TemporalType.TIME)
    private @NotNull Date timeStart;
    @Temporal(TemporalType.DATE)
    private Date dateFinish;
    @Temporal(TemporalType.TIME)
    private Date timeFinish;

    @ManyToOne
    @JoinColumn(name = "maintenanceStatusId")
    private @NotNull MaintenanceStatus status;

    @ManyToOne
    @JoinColumn(name = "placeId")
    private @NotNull Place place;

    @ManyToOne
    @JoinColumn(name = "staffId")
    private @NotNull Staff staff;

    public Maintenance() {
    }

    public Maintenance(String maintenanceName, String description, Date dateStart, Date timeStart, Date dateFinish, Date timeFinish, MaintenanceStatus status, Place place, Staff staff) {
        this.maintenanceName = maintenanceName;
        this.description = description;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateFinish = dateFinish;
        this.timeFinish = timeFinish;
        this.status = status;
        this.place = place;
        this.staff = staff;
    }
}
