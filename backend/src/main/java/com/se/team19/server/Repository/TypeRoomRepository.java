package com.se.team19.server.Repository;


import com.se.team19.server.Entity.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeRoomRepository extends JpaRepository<TypeRoom, Long> {
    TypeRoom findById(long id);
//    RoomStatus findByStatusName(String name);
}