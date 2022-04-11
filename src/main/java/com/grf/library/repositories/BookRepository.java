package com.grf.library.repositories;

import com.grf.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

//    @Query("from book") // hql
}
