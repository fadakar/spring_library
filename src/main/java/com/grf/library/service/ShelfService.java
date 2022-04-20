package com.grf.library.service;

import com.grf.library.repository.model.ShelfModel;

import java.util.List;

public interface ShelfService {

    List<ShelfModel> findAll();

    ShelfModel getById(long id);

    ShelfModel save(ShelfModel shelfModel);

    void deleteById(long id);

}
