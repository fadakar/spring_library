package com.grf.library.service;

import com.grf.library.repository.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> list();
}
