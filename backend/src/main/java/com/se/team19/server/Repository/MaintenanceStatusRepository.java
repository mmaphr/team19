package com.se.team19.server.Repository;

import com.se.team19.server.Entity.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MaintenanceStatusRepository extends JpaRepository<MaintenanceStatus, Long> {
    MaintenanceStatus findById(long Id);
}
