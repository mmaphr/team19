package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "OlderDisease")
public class OlderDisease {
    @Id
    @SequenceGenerator(name = "olderdisease_seq", sequenceName = "olderdisease_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "olderdisease_seq")
    @Column(name = "OlderDisease_ID", unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String diseasename;




}