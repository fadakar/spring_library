package com.grf.library.service;

import com.grf.library.repository.model.BorrowerModel;

import java.util.List;

public interface BorrowerService {

    List<BorrowerModel> findAll();

    BorrowerModel getById(long id);

    BorrowerModel save(BorrowerModel book);

    void deleteById(long id);

}
