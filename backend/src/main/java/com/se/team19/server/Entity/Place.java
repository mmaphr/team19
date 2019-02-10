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
public class Place {
    @Id
    @GeneratedValue(generator = "Places_Seq")
    private @NonNull Long placeId;
    private @NonNull String placeName;
    private @NonNull String location;

    public Place(@NonNull String placeName, @NonNull String location) {
        this.placeName = placeName;
        this.location = location;
    }
}
