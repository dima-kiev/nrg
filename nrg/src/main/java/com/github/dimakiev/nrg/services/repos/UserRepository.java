package com.github.dimakiev.nrg.services.repos;

import com.github.dimakiev.nrg.entities.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {



}
