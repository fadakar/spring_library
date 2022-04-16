package com.grf.library.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrower")
@Data
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_book_id")
    private Book book;

    @Column(name = "borrower_from_date")
    private Date fromDate;

    @Column(name = "borrower_to_date")
    private Date toDate; // time bargasht ya tamdid

    @Column(name = "borrower_return_date")
    private Date ReturnDate; // rooz tahvil
}
