package com.grf.library.service.impl;

import com.grf.library.exception.BusinessException;
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
    public List<BorrowerModel> findAll() throws BusinessException {
        try {
            List<Borrower> borrowers = repo.findAll();
            List<BorrowerModel> borrowerModels = new ArrayList<>();
            for (Borrower borrower : borrowers) {
                borrowerModels.add(mapper.EntityToModel(borrower));
            }
            return borrowerModels;
        } catch (Exception ex) {
            throw new BusinessException("Borrower Not Found");
        }
    }

    @Override
    public BorrowerModel getById(long id) throws BusinessException {
        try {
            Borrower borrower = repo.getById(id);
            if (borrower != null) {
                return mapper.EntityToModel(borrower);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new BusinessException("Borrower Not Found");
        }
    }

    @Override
    public BorrowerModel save(BorrowerModel borrowerModel) throws BusinessException{
        try{
            Borrower borrower = mapper.ModelToEntity(borrowerModel);
            Borrower saveBorrower = repo.save(borrower);
            return mapper.EntityToModel(saveBorrower);
        }
        catch (Exception ex) {
            throw new BusinessException("An error occurs when save Borrower");
        }
    }

    @Override
    public void deleteById(long id) throws BusinessException{
        try{
            Borrower foundBook = repo.getById(id);
            if (foundBook != null) {
                repo.deleteById(foundBook.getId());
            }
        }
        catch (Exception ex) {
            throw new BusinessException("An error occurs when delete Borrower");
        }
    }
}
