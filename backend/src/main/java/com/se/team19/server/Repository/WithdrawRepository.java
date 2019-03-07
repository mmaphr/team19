package com.se.team19.server.Repository;

import com.se.team19.server.Entity.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface WithdrawRepository extends JpaRepository<Withdraw,Long> {
    Collection<Withdraw> findByWithdrawId(long l);
    Withdraw findTopByOrderByWithdrawIdDesc ();
}
