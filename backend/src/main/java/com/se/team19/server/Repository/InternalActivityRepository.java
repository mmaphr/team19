package com.se.team19.server.Repository;

import com.se.team19.server.Entity.InternalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface InternalActivityRepository extends JpaRepository<InternalActivity, Long> {
    @Query("SELECT t FROM InternalActivity t ORDER BY day.dayId ASC,time.timeId ASC")
    Collection<InternalActivity> getAll();
}