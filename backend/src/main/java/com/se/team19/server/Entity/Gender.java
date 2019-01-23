package com.se.team19.server.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
    @Column(name="GENDER_ID",unique = true, nullable = false)
    private @NonNull Long GenderId;
    private @NonNull String GenderName;

    public Gender() {}

    public Gender(String genderName) {
        GenderName = genderName;
    }
}
