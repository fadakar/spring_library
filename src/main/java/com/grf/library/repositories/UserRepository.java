package com.grf.library.repositories;

import com.grf.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();
}
