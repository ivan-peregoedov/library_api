package com.peregoedov.library.project.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Book with id " + id + " not found"));
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        bookRepository.findById(book.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Book with id " + book.getId() + " not found"));

        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }

}
