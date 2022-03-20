package com.grf.library.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "shelf_no", nullable = false)
    private int shelfNO;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "shelf", cascade = CascadeType.ALL)
    private List<Book> books;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getShelfNO() {
        return shelfNO;
    }

    public void setShelfNO(int shelfNO) {
        this.shelfNO = shelfNO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
