package com.grf.library.service.impl;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.UserRepository;
import com.grf.library.repository.entity.User;
import com.grf.library.repository.mapper.UserMapper;
import com.grf.library.repository.model.UserModel;
import com.grf.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserModel> findAll() throws BusinessException{
        try{
            List<User> users = repo.findAll();
            List<UserModel> userModels = new ArrayList<>();
            for (User user : users) {
                userModels.add(mapper.EntityToModel(user));
            }
            return userModels;
        }
        catch (Exception ex) {
            throw new BusinessException("User Not Found");
        }
    }

    @Override
    public UserModel getById(long id) throws BusinessException {
        try {
            User user = repo.getById(id);
            if (user != null) {
                return mapper.EntityToModel(user);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new BusinessException("User Not Found");
        }

    }

    @Override
    public UserModel save(UserModel userModel) throws BusinessException {
        try {
            User user = mapper.ModelToEntity(userModel);
            User savedUser = repo.save(user);
            return mapper.EntityToModel(savedUser);
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when save user");
        }

    }

    @Override
    public void deleteById(long id) throws BusinessException {
        try {
            User foundUser = repo.getById(id);
            if (foundUser != null) {
                repo.deleteById(foundUser.getId());
            }
        } catch (Exception ex) {
            throw new BusinessException("An error occurs when delete user");
        }

    }
}
