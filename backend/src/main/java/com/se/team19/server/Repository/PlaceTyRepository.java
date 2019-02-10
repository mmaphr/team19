package com.se.team19.server.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.se.team19.server.Entity.PlaceTy;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PlaceTyRepository extends JpaRepository<PlaceTy, Long>{
    PlaceTy findById(long id);
}
