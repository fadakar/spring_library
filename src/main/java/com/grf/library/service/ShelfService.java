package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.ShelfModel;

import java.util.List;

public interface ShelfService {

    List<ShelfModel> findAll() throws BusinessException;

    ShelfModel getById(long id) throws BusinessException;

    ShelfModel save(ShelfModel shelfModel) throws BusinessException;

    void deleteById(long id) throws BusinessException;

}
