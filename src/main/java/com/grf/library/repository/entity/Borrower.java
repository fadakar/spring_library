package com.grf.library.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrower")
public class Borrower  implements Serializable {
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
