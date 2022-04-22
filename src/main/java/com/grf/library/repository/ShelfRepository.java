package com.grf.library.repository;

import com.grf.library.repository.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {

}
