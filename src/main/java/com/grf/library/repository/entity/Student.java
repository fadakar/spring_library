package com.grf.library.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
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
