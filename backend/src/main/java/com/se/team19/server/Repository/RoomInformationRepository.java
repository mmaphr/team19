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

    RoomInformation findByOlder(DataOlder older);


}
