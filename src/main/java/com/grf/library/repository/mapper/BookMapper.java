package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.Book;
import com.grf.library.repository.model.BookModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book ModelToEntity(BookModel bookModel);

    BookModel EntityToModel(Book book);
}
