package com.peregoedov.library.project.dto;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Book DTO")
public class BookDto {

    @Schema(description = "Book title", example = "Trainspotting")
    private String title;

    @Schema(description = "Book author", example = "Irvine Welsh")
    private String author;

    @Schema(description = "Book published date", example = "2024-11-11")
    private Date publishedDate;
}
