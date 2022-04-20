package com.grf.library.service.impl;

import com.grf.library.repository.BorrowerRepository;
import com.grf.library.repository.entity.Borrower;
import com.grf.library.repository.mapper.BorrowerMapper;
import com.grf.library.repository.model.BorrowerModel;
import com.grf.library.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    BorrowerRepository repo;

    @Autowired
    BorrowerMapper mapper;

    @Override
    public List<BorrowerModel> findAll() {
        List<Borrower> borrowers = repo.findAll();
        List<BorrowerModel> bookModels = new ArrayList<>();
        for (Borrower borrower : borrowers) {
            bookModels.add(mapper.EntityToModel(borrower));
        }
        return bookModels;
    }

    @Override
    public BorrowerModel getById(long id) {
        Borrower borrower = repo.getById(id);
        if (borrower != null) {
            return mapper.EntityToModel(borrower);
        } else {
            return null;
        }
    }

    @Override
    public BorrowerModel save(BorrowerModel userModel) {
        Borrower borrower = mapper.ModelToEntity(userModel);
        Borrower saveBorrower = repo.save(borrower);
        return mapper.EntityToModel(saveBorrower);
    }

    @Override
    public void deleteById(long id) {
        Borrower foundBook = repo.getById(id);
        if (foundBook != null) {
            repo.deleteById(foundBook.getId());
        }
    }
}
