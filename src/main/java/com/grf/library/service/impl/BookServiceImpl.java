package com.grf.library.service.impl;

import com.grf.library.repository.BookRepository;
import com.grf.library.repository.entity.Book;
import com.grf.library.repository.mapper.BookMapper;
import com.grf.library.repository.model.BookModel;
import com.grf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repo;

    @Autowired
    BookMapper mapper;

    @Override
    public List<BookModel> findAll() {
        List<Book> books = repo.findAll();
        List<BookModel> bookModels = new ArrayList<>();
        for (Book book : books) {
            bookModels.add(mapper.EntityToModel(book));
        }
        return bookModels;
    }

    @Override
    public BookModel getById(long id) {
        Book book = repo.getById(id);
        if (book != null) {
            return mapper.EntityToModel(book);
        } else {
            return null;
        }
    }

    @Override
    public BookModel save(BookModel bookModel) {
        Book book = mapper.ModelToEntity(bookModel);
        Book savedBook = repo.save(book);
        return mapper.EntityToModel(savedBook);
    }

    @Override
    public void deleteById(long id) {
        Book foundBook = repo.getById(id);
        if (foundBook != null) {
            repo.deleteById(foundBook.getId());
        }
    }
}
