package com.grf.library.repository.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin;
    private String description;



}
