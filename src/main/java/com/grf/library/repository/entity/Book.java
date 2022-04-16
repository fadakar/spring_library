package com.grf.library.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "book_publication_year")
    private String publicationYear;

    @Column(name = "book_language", nullable = false)
    private String language;

    @Column(name = "book_description")
    private String description;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Borrower> borrowers;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;
}
