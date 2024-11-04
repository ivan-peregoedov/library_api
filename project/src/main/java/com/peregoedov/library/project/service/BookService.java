package com.peregoedov.library.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peregoedov.library.project.model.Book;
import com.peregoedov.library.project.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
