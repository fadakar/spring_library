package com.grf.library.repository;

import com.grf.library.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();
}
