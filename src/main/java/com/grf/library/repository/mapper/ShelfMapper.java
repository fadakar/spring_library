package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.Shelf;
import com.grf.library.repository.model.ShelfModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShelfMapper {
    Shelf ModelToEntity(ShelfModel shelfModel);

    ShelfModel EntityToModel(Shelf shelf);
}
