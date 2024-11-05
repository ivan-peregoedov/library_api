package com.peregoedov.library.project.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peregoedov.library.project.dto.BookDto;
import com.peregoedov.library.project.model.Book;
import com.peregoedov.library.project.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Book Methods")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Operation(summary = "Get all books", description = "Returns a list of all books")
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @Operation(summary = "Get book by id", description = "Returns a book by id")
    @ApiResponse(responseCode = "200", description = "The requested book")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookService.findById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create new book", description = "Creates a new book")
    @ApiResponse(responseCode = "201", description = "Book created successfully")
    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        Book savedBook = bookService.save(Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publishedDate(bookDto.getPublishedDate())
                .build());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @Operation(summary = "Update book", description = "Updates a book")
    @ApiResponse(responseCode = "200", description = "Book updated successfully")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        Book updatedBook = bookService.update(book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }

    @Operation(summary = "Delete book by id", description = "Deletes a book by id")
    @ApiResponse(responseCode = "204", description = "Book deleted successfully")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
