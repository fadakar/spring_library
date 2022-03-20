package com.grf.library.dao;

import com.grf.library.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    @Override
    List<Category> findAll();
}
