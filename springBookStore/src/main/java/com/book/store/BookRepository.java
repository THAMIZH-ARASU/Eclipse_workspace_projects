package com.book.store;

import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {
    // Define custom query methods if needed
}