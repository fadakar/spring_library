package com.grf.library.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shelf")
public class Shelf implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shelf_floor", nullable = false)
    private int floor;

    @Column(name = "shelf_shelf_no", nullable = false)
    private int shelfNO;

    @Column(name = "shelf_description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "shelf")
    private List<Book> books;
}
