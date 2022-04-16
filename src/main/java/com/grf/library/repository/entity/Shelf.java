package com.grf.library.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelf")
@Data
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shelf_floor", nullable = false)
    private int floor;

    @Column(name = "shelf_shelf_no", nullable = false)
    private int shelfNO;

    @Column(name = "shelf_description")
    private String description;

    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL)
    private List<Book> books;
}
