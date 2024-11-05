package com.peregoedov.library.project.model;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book")
@Schema(description = "Book model")
public class Book {

    @Schema(description = "Book id", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Book title", example = "Trainspotting")
    @Column(nullable = false)
    private String title;

    @Schema(description = "Book author", example = "Irvine Welsh")
    @Column(nullable = false)
    private String author;

    @Schema(description = "Book published date", example = "2024-11-11")
    @Column(nullable = false)
    private Date publishedDate;
}
