package com.grf.library.service;

import com.grf.library.repository.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findAll();

    UserModel getById(long id);

    UserModel save(UserModel book);

    void deleteById(long id);

}
