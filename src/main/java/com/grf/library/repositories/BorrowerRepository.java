package com.grf.library.repositories;

import com.grf.library.entities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    @Override
    List<Borrower> findAll();
}
