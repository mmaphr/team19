package com.se.team19.server.Repository;

import com.se.team19.server.Entity.DaysOfTheWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DaysOfTheWeekRepository extends JpaRepository<DaysOfTheWeek, Long> {
    DaysOfTheWeek findById(long id);
}

