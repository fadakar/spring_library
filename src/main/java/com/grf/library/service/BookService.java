package com.grf.library.service;

import com.grf.library.repository.model.BookModel;

import java.util.List;

public interface BookService {

    List<BookModel> findAll();

    BookModel getById(long id);

    BookModel save(BookModel book);

    void deleteById(long id);

}
