package com.se.team19.server.Repository;

import com.se.team19.server.Entity.InternalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InternalActivityRepository extends JpaRepository<InternalActivity, Long> {

}