package com.grf.library.service.impl;

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
    public List<CategoryModel> findAll() {
        List<Category> categories = repo.findAll();
        List<CategoryModel> categoryModels = new ArrayList<>();
        for (Category category : categories) {
            categoryModels.add(mapper.EntityToModel(category));
        }
        return categoryModels;
    }

    @Override
    public CategoryModel getById(long id) {
        Category category = repo.getById(id);
        if (category != null) {
            return mapper.EntityToModel(category);
        } else {
            return null;
        }
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        Category category = mapper.ModelToEntity(categoryModel);
        Category savedCategory = repo.save(category);
        return mapper.EntityToModel(savedCategory);
    }

    @Override
    public void deleteById(long id) {
        Category foundCategory = repo.getById(id);
        if (foundCategory != null) {
            repo.deleteById(foundCategory.getId());
        }
    }
}
