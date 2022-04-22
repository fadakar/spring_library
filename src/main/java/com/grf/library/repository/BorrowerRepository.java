package com.grf.library.repository;

import com.grf.library.repository.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
