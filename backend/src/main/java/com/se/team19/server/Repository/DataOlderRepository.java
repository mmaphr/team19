package com.se.team19.server.Repository;

import com.se.team19.server.Entity.DataOlder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DataOlderRepository extends JpaRepository<DataOlder, Long> {
    DataOlder findById(long id);
    DataOlder findByOldername(String OlderName);
}