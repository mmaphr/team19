package com.se.team19.server.Repository;

import com.se.team19.server.Entity.TimeDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TimeDurationRepository extends JpaRepository<TimeDuration, Long> {
    TimeDuration findById(long id);
}

