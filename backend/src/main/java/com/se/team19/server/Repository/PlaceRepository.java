package com.se.team19.server.Repository;

import com.se.team19.server.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findById(long Id);
}
