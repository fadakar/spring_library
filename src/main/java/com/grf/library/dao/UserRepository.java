package com.grf.library.dao;

import com.grf.library.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Override
    List<User> findAll();
}
