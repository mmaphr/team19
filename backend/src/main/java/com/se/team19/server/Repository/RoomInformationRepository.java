package com.se.team19.server.Repository;

import com.se.team19.server.Entity.DataOlder;
import com.se.team19.server.Entity.RoomInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;

@RepositoryRestResource
public interface RoomInformationRepository extends JpaRepository<RoomInformation, Long> {
    RoomInformation findById(long id);
    RoomInformation findByRoomnumber(String roomnumber);

//    RoomStatus findByStatusName(String name);
    RoomInformation findByOlder1(DataOlder older1);
    RoomInformation findByOlder2(DataOlder older2);
    RoomInformation findByOlder3(DataOlder older3);

}