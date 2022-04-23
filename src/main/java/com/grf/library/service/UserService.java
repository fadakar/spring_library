package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findAll() throws BusinessException;

    UserModel getById(long id) throws BusinessException;

    UserModel save(UserModel userModel) throws BusinessException;

    void deleteById(long id) throws BusinessException;

}
