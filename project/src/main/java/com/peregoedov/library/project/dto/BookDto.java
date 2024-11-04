package com.peregoedov.library.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private Date publishedDate;
}
