package com.grf.library.repository.model;


import com.grf.library.repository.entity.Book;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryModel implements Serializable {
    private long id;
    private String title;
    private String description;
    private List<Book> books;
}
