package com.grf.library.dao;

import com.grf.library.entities.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    @Override
    List<Book> findAll();
}
