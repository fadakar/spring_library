package com.grf.library.service.impl;

import com.grf.library.exception.BusinessException;
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
    public List<ShelfModel> findAll() throws BusinessException{
        try{
            List<Shelf> shelves = repo.findAll();
            List<ShelfModel> shelfModels = new ArrayList<>();
            for (Shelf shelf : shelves) {
                shelfModels.add(mapper.EntityToModel(shelf));
            }
            return shelfModels;
        }
        catch (Exception ex) {
            throw new BusinessException("Shelf Not Found");
        }
    }

    @Override
    public ShelfModel getById(long id) throws BusinessException{
        try {
            Shelf shelf = repo.getById(id);
            if (shelf != null) {
                return mapper.EntityToModel(shelf);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new BusinessException("Shelf Not Found");
        }

    }

    @Override
    public ShelfModel save(ShelfModel shelfModel) throws BusinessException {
        try {
            Shelf shelf = mapper.ModelToEntity(shelfModel);
            Shelf savedShelf = repo.save(shelf);
            return mapper.EntityToModel(savedShelf);
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when save shelf");
        }

    }

    @Override
    public void deleteById(long id) throws BusinessException {
        try {
            Shelf foundShelf = repo.getById(id);
            if (foundShelf != null) {
                repo.deleteById(foundShelf.getId());
            }
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when delete shelf");
        }

    }
}
