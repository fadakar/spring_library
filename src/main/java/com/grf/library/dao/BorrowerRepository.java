package com.grf.library.dao;

import com.grf.library.entities.Borrower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowerRepository extends CrudRepository<Borrower, Long> {

    @Override
    List<Borrower> findAll();
}
