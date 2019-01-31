package com.se.team19.server.Repository;

import com.se.team19.server.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Collection;

public interface RelativesStatusRepository extends JpaRepository<RelativesStatus, Long> {
    RelativesStatus findById(long id);
}
