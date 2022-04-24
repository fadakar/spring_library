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
public class CategoryModel implements Serializable {
    private long id;
    private String title;
    private String description;

    @JsonIgnore
    private List<BookModel> books;
}
