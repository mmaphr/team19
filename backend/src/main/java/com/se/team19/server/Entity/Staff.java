package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue
    @Column(name="Staff_ID")
    private @NonNull Long staff_id;
    private @NonNull String staffName;

    public Staff() {}

    public Staff(Long staff_id, String staffName) {
        this.staff_id = staff_id;
        this.staffName = staffName;
    }
}
