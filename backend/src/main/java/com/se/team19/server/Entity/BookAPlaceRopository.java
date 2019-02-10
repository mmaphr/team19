package com.se.team19.server.Repository;

import com.se.team19.server.Entity.BookAPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface BookAPlaceRopository extends JpaRepository<BookAPlace, Long> {
    BookAPlace findById(long id);
}
