package com.grf.library.repository.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grf.library.repository.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShelfModel implements Serializable {
    private long id;
    private int floor;
    private int shelfNO;
    private String description;

    private List<Book> books;
}
