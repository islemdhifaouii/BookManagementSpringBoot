package com.horizon.labspring.repository;

import com.horizon.labspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposotory extends JpaRepository<Book, Long> {
    Boolean existsByTitle(String title);
    void deleteByIsbn(String Isbn);
    Boolean existsByIsbn(String ISBN);
    int countByCategory(String category);
}
