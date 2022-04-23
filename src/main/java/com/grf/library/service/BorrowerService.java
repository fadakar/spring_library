package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.entity.Book;
import com.grf.library.repository.entity.Borrower;
import com.grf.library.repository.model.BorrowerModel;

import java.util.List;

public interface BorrowerService {

    List<BorrowerModel> findAll() throws BusinessException;

    BorrowerModel getById(long id) throws BusinessException;

    BorrowerModel save(BorrowerModel borrowerModel) throws BusinessException;

    void deleteById(long id) throws BusinessException;

    Borrower getLastOpen(long bookId) throws BusinessException;
}
