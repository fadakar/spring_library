package com.grf.library.service.impl;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.CategoryRepository;
import com.grf.library.repository.entity.Category;
import com.grf.library.repository.mapper.CategoryMapper;
import com.grf.library.repository.model.CategoryModel;
import com.grf.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repo;

    @Autowired
    CategoryMapper mapper;

    @Override
    public List<CategoryModel> findAll() throws BusinessException {
        try {
            List<Category> categories = repo.findAll();
            List<CategoryModel> categoryModels = new ArrayList<>();
            for (Category category : categories) {
                categoryModels.add(mapper.EntityToModel(category));
            }
            return categoryModels;
        } catch (Exception ex) {
            throw new BusinessException("Category Not Found");
        }
    }

    @Override
    public CategoryModel getById(long id) throws BusinessException {
        try {
            Category category = repo.getById(id);
            if (category != null) {
                return mapper.EntityToModel(category);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new BusinessException("Category Not Found");
        }

    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) throws BusinessException {
        try {
            Category category = mapper.ModelToEntity(categoryModel);
            Category savedCategory = repo.save(category);
            return mapper.EntityToModel(savedCategory);
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when save category");
        }

    }

    @Override
    public void deleteById(long id) throws BusinessException {
        try {
            Category foundCategory = repo.getById(id);
            if (foundCategory != null) {
                repo.deleteById(foundCategory.getId());
            }
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when delete category");
        }

    }
}
