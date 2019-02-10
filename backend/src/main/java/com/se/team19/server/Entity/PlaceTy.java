package com.se.team19.server.Entity;

import lombok.*;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class PlaceTy {
    @Id
    @SequenceGenerator(name="place_seq",sequenceName="place_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="place_seq")
    @Column(name="place_id",unique = true)

    private @NonNull Long place_id;
    private @NotNull String typePlace;




    public PlaceTy() {
    }

    public PlaceTy(String typePlace) {
        this.typePlace = typePlace;
    }
}
