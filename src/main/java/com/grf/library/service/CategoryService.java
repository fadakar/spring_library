package com.grf.library.service;

import com.grf.library.repository.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    List<CategoryModel> findAll();

    CategoryModel getById(long id);

    CategoryModel save(CategoryModel book);

    void deleteById(long id);

}
