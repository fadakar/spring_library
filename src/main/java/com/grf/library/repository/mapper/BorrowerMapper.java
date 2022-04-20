package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.Borrower;
import com.grf.library.repository.model.BorrowerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BorrowerMapper {
    Borrower ModelToEntity(BorrowerModel borrowerModel);

    BorrowerModel EntityToModel(Borrower borrower);
}
