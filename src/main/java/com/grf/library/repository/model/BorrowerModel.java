package com.grf.library.repository.model;


import com.grf.library.repository.entity.Book;
import com.grf.library.repository.entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BorrowerModel implements Serializable {
    private long id;
    private Student student;
    private Book book;
    private Date fromDate;
    private Date toDate; // time bargasht ya tamdid
    private Date ReturnDate; // rooz tahvil
}
