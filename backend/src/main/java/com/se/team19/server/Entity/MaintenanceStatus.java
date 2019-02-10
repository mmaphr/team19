package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table
public class MaintenanceStatus {
    @Id
    @GeneratedValue(generator = "MaintenanceStatus_Seq")
    private @NonNull Long maintenanceStatusId;
    private @NonNull String statusName;

    public MaintenanceStatus(@NonNull String statusName) {
        this.statusName = statusName;
    }
}
