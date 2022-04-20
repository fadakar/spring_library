package com.grf.library.service.impl;

import com.grf.library.repository.ShelfRepository;
import com.grf.library.repository.entity.Shelf;
import com.grf.library.repository.mapper.ShelfMapper;
import com.grf.library.repository.model.ShelfModel;
import com.grf.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    ShelfRepository repo;

    @Autowired
    ShelfMapper mapper;

    @Override
    public List<ShelfModel> findAll() {
        List<Shelf> shelves = repo.findAll();
        List<ShelfModel> shelfModels = new ArrayList<>();
        for (Shelf shelf : shelves) {
            shelfModels.add(mapper.EntityToModel(shelf));
        }
        return shelfModels;
    }

    @Override
    public ShelfModel getById(long id) {
        Shelf shelf = repo.getById(id);
        if (shelf != null) {
            return mapper.EntityToModel(shelf);
        } else {
            return null;
        }
    }

    @Override
    public ShelfModel save(ShelfModel shelfModel) {
        Shelf shelf = mapper.ModelToEntity(shelfModel);
        Shelf savedShelf = repo.save(shelf);
        return mapper.EntityToModel(savedShelf);
    }

    @Override
    public void deleteById(long id) {
        Shelf foundShelf = repo.getById(id);
        if (foundShelf != null) {
            repo.deleteById(foundShelf.getId());
        }
    }
}
