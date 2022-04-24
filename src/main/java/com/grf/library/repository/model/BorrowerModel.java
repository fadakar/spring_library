package com.grf.library.repository.model;


import com.grf.library.repository.entity.Book;
import com.grf.library.repository.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerModel implements Serializable {
    private long id;
    private StudentModel student;
    private BookModel book;
    private Date fromDate;
    private Date toDate; // time bargasht ya tamdid
    private Date ReturnDate; // rooz tahvil
}
