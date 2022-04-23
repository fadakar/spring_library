package com.grf.library.repository;

import com.grf.library.repository.entity.Book;
import com.grf.library.repository.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

//    Borrower findByBookAndReturnDateIsNull(Book book);
//    Borrower findBorrowerByBook_IdAndReturnDateIsNull(long bookId);

    @Query("select t from Borrower t where t.book.id = :bookId and t.ReturnDate is null")
    Borrower findLastOpen(long bookId);
}

