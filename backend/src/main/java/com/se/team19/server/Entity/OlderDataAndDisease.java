package com.se.team19.server.Entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "OlderDataAndDisease")
public class OlderDataAndDisease {
    @Id
    @SequenceGenerator(name = "olderdataanddisease_seq", sequenceName = "olderdataanddisease_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "olderdataanddisease_seq")
    @Column(name = "OlderDataAndDisease_ID", unique = true, nullable = false)
    private @NotNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DataOlder.class)
    @JoinColumn(name = "DataOlder_ID", insertable = true)
    private @NotNull DataOlder dataOlderADiseaseDataOlder;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = OlderDisease.class)
    @JoinColumn(name = "OlderDisease_ID", insertable = true)
    private @NotNull OlderDisease dataOlderADiseaseOlderDisease;

    public OlderDataAndDisease(){}

    public OlderDataAndDisease( DataOlder dataOlderADiseaseDataOlder, OlderDisease dataOlderADiseaseOlderDisease) {
        this.dataOlderADiseaseDataOlder = dataOlderADiseaseDataOlder;
        this.dataOlderADiseaseOlderDisease = dataOlderADiseaseOlderDisease;
    }
}
