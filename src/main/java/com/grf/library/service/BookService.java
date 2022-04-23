package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.BookModel;

import java.util.List;

public interface BookService {

    List<BookModel> findAll() throws BusinessException;

    BookModel getById(long id) throws BusinessException;

    BookModel save(BookModel book) throws BusinessException;

    void deleteById(long id) throws BusinessException;

    Object getStatus(long bookId) throws BusinessException;

}
