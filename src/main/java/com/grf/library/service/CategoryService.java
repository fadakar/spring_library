package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    List<CategoryModel> findAll() throws BusinessException;

    CategoryModel getById(long id) throws BusinessException;

    CategoryModel save(CategoryModel categoryModel) throws BusinessException;

    void deleteById(long id) throws BusinessException;

}
