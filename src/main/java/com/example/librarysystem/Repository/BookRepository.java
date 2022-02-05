package com.example.librarysystem.Repository;

import com.example.librarysystem.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Long> {
    Books findBooksByAuthor(String author);
}
