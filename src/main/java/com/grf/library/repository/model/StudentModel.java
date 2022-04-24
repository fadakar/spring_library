package com.grf.library.repository.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grf.library.repository.entity.Borrower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int gender;
    private String cellphone;
    private String telephone;

    @JsonIgnore
    private List<BorrowerModel> borrowers;
}
