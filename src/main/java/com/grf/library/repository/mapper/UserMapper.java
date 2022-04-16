package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.User;
import com.grf.library.repository.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User ModelToEntity(UserModel userModel);

    UserModel EntityToModel(User user);
}
