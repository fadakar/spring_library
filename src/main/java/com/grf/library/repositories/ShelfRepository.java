package com.grf.library.repositories;

import com.grf.library.entities.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {

    @Override
    List<Shelf> findAll();
}
