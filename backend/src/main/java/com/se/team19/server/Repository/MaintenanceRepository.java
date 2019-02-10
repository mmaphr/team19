package com.se.team19.server.Repository;

import com.se.team19.server.Entity.Maintenance;
import com.se.team19.server.Entity.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    Collection<Maintenance> findAllByStatus(MaintenanceStatus status);
    Collection<Maintenance> findAllByStatusOrderByDateStartAsc(MaintenanceStatus status);
    Collection<Maintenance> findAllByStatusOrderByDateFinishDesc(MaintenanceStatus status);
}
