package com.grf.library.repository;

import com.grf.library.repository.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    @Override
    List<Borrower> findAll();
}
