package com.grf.library.repository.model;


import com.grf.library.repository.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookModel implements Serializable {
    private long id;
    private String title;
    private String publicationYear;
    private String language;
    private String description;
    private List<Borrower> borrowers;
    private Category category;
    private Shelf shelf;
}