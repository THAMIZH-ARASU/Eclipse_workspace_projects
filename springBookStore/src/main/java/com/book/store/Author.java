package com.book.store;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and setters
}