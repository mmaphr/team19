package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "OlderDataAndDisease")
public class OlderDataAndDisease {
    @Id
    @SequenceGenerator(name = "olderdataanddisease_seq", sequenceName = "olderdataanddisease_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "olderdataanddisease_seq")
    @Column(name = "OlderDataAndDisease_ID", unique = true, nullable = false)
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DataOlder.class)
    @JoinColumn(name = "DataOlder_ID", insertable = true)
    private Gender dataOlderAndDiseaseDataOlder;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = OlderDisease.class)
    @JoinColumn(name = "OlderDisease_ID", insertable = true)
    private Province dataOlderAndDiseaseOlderDisease;

}