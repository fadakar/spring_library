package com.grf.library.repository.model;


import com.grf.library.repository.entity.Borrower;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StudentModel implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int gender;
    private String cellphone;
    private String telephone;
    private List<Borrower> borrowers;
}
