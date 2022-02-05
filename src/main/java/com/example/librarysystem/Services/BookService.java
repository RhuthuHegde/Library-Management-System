package com.example.librarysystem.Services;

import com.example.librarysystem.Models.Books;

import java.util.List;


public interface BookService {
    //adding the books to DB
    Books savebooks(Books book);
    //gets all the books saved
    List<Books> getAllbooks();
//    gets the books by their id
    Books findBooksByAuthor(String author);
    //counts the books
    Long count();
    //update the existing books
    Books updatebooks(Long id,Books book);
    //delete book
    Books deletebooks(Long id);
}
