package com.grf.library.repository.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin;
    private String description;
}
