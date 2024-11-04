package com.peregoedov.library.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peregoedov.library.project.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
