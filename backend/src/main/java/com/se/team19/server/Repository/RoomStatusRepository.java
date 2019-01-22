package com.se.team19.server.Repository;

import com.se.team19.server.Entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {
    RoomStatus findById(long id);
//    RoomStatus findByStatusName(String name);
}