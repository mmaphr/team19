package com.example.demo.entity;

import javax.persistence.*;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Organized {
    @Id
    @SequenceGenerator(name="organized_seq",sequenceName="organized_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="organized_seq")
    @Column(name="organized_id",unique = true)

    private @NonNull Long organized_id;
    private @NonNull String organized;

    public Organized(){}
    public Organized(String organized) {
        this.organized = organized;
    }

}
