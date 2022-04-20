package com.grf.library.repository.model;


import com.grf.library.repository.entity.Book;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShelfModel implements Serializable {
    private long id;
    private int floor;
    private int shelfNO;
    private String description;
    private List<Book> books;
}
