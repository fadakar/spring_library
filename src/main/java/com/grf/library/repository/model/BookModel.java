package com.grf.library.repository.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grf.library.repository.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel implements Serializable {
    private long id;
    private String title;
    private String publicationYear;
    private String language;
    private String description;

    @JsonIgnore
    private List<BorrowerModel> borrowers;

    private Category category;
    private Shelf shelf;
}
