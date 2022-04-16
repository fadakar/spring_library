package com.grf.library.repository.model;


import lombok.Data;

@Data
public class UserModel {
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin;
    private String description;



}
