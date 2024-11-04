package com.peregoedov.library.project.service;

import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.peregoedov.library.project.model.Book;
import com.peregoedov.library.project.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testFindById() {
        Book book = Book.builder()
                .id(1L)
                .title("Title")
                .author("Author")
                .publishedDate(Date.valueOf("2024-11-11"))
                .build();

        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.findById(1L);

        Assertions.assertEquals(book, result);
    }

    @Test
    void testFindByIdNotFound() {
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(NoSuchElementException.class, () -> bookService.findById(1L));
    }
}
