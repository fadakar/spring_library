package com.grf.library.dao;

import com.grf.library.entities.Shelf;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShelfRepository extends PagingAndSortingRepository<Shelf, Long> {

    @Override
    List<Shelf> findAll();
}
