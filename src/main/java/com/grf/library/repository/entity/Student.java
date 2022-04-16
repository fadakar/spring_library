package com.grf.library.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_first_name", nullable = false)
    private String firstName;

    @Column(name = "student_last_name", nullable = false)
    private String lastName;

    @Column(name = "student_birthday")
    private Date birthday;

    @Column(name = "student_gender", nullable = false)
    private int gender;

    @Column(name = "student_cellphone", nullable = false)
    private String cellphone;

    @Column(name = "student_telephone")
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Borrower> borrowers;


}
