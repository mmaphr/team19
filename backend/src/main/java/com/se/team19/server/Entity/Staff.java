package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "staff")
public class Staff {
    @Id
    @SequenceGenerator(name="staff_seq",sequenceName="staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="staff_seq")
    @Column(name ="STAFF_ID",unique = true, nullable = false)
    private @NonNull Long StaffId;
    private @NonNull String StaffName;
    private @NonNull int Age;
    private @NonNull String Address;
    private @NonNull String Phone;
    private @NonNull String Username;
    private @NonNull String Password;

    public Staff() {}

    public Staff(String staffName, @NonNull int age, String address, String phone, String username, String password, Gender staffGender, Province staffProvince, Position staffPosition) {
        StaffName = staffName;
        Age = age;
        Address = address;
        Phone = phone;
        Username = username;
        Password = password;
        StaffGender = staffGender;
        StaffProvince = staffProvince;
        StaffPosition = staffPosition;
    }

    @ManyToOne()
    @JoinColumn(name = "GENDER_ID", insertable = true)
    private Gender StaffGender;

    @ManyToOne()
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province StaffProvince;

    @ManyToOne()
    @JoinColumn(name = "POSITION_ID", insertable = true)
    private Position StaffPosition;


}
