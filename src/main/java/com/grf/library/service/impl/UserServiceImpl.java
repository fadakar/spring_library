package com.grf.library.service.impl;

import com.grf.library.repository.UserRepository;
import com.grf.library.repository.mapper.UserMapper;
import com.grf.library.repository.model.UserModel;
import com.grf.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserModel> list() {
        return null;
    }
}
