package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.Category;
import com.grf.library.repository.model.CategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category ModelToEntity(CategoryModel categoryModel);

    CategoryModel EntityToModel(Category category);
}
