package com.grf.library.service.impl;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.BookRepository;
import com.grf.library.repository.entity.Book;
import com.grf.library.repository.mapper.BookMapper;
import com.grf.library.repository.mapper.CategoryMapper;
import com.grf.library.repository.mapper.ShelfMapper;
import com.grf.library.repository.model.BookModel;
import com.grf.library.repository.model.CategoryModel;
import com.grf.library.repository.model.ShelfModel;
import com.grf.library.service.BookService;
import com.grf.library.service.CategoryService;
import com.grf.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repo;

    @Autowired
    @Qualifier("shelfServiceImpl")
    ShelfService shelfService;

    @Autowired
    @Qualifier("categoryServiceImpl")
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ShelfMapper shelfMapper;

    @Autowired
    BookMapper mapper;

    @Override
    public List<BookModel> findAll() throws BusinessException {
        try {

            List<Book> books = repo.findAll();
            List<BookModel> bookModels = new ArrayList<>();
            for (Book book : books) {
                bookModels.add(mapper.EntityToModel(book));
            }
            return bookModels;
        } catch (Exception ex) {
            throw new BusinessException("Book Not Found");
        }
    }

    @Override
    public BookModel getById(long id) throws BusinessException {
        try {
            Book book = repo.getById(id);
            if (book != null) {
                return mapper.EntityToModel(book);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new BusinessException("Book Not Found");
        }
    }

    @Override
    public BookModel save(BookModel bookModel) throws BusinessException {
        Book book = mapper.ModelToEntity(bookModel);

        // set shelf
        if (bookModel.getShelf() != null) {
            try {
                ShelfModel shelfModel = shelfService.getById(bookModel.getShelf().getId());
                bookModel.setShelf(shelfMapper.ModelToEntity(shelfModel));
            } catch (Exception ex) {
                throw new BusinessException("Self Not Found");
            }

        }

        //set category
        if (bookModel.getCategory() != null) {
            try {
                CategoryModel categoryModel = categoryService.getById(bookModel.getCategory().getId());
                bookModel.setCategory(categoryMapper.ModelToEntity(categoryModel));
            } catch (Exception ex) {
                throw new BusinessException("Category Not Found");
            }
        }


        try {
            Book savedBook = repo.save(book);
            return mapper.EntityToModel(savedBook);
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when save Book");
        }
    }

    @Override
    public void deleteById(long id) throws BusinessException {
        try {
            Book foundBook = repo.getById(id);
            if (foundBook != null) {
                repo.deleteById(foundBook.getId());
            }
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when delete Book");
        }

    }
}
