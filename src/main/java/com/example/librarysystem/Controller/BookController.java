package com.example.librarysystem.Controller;
import com.example.librarysystem.Models.Books;
import com.example.librarysystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
        @GetMapping("/")
        public String newPage()
        {
            return "Welcome to library management system";
        }
        @GetMapping({"/books"})
        public List<Books> getbooks()
        {
            return bookService.getAllbooks();
        }
        @GetMapping("/countbooks")
        public String count()
        {
            Long val=bookService.count();
            return "The number of books in the library are: "+val;
        }
        @GetMapping("/books/{author}")
        public Books search(@PathVariable String author)
        {
            return bookService.findBooksByAuthor(author);
        }
        @PostMapping("/addbooks")
        public String add(@RequestBody Books book)
        {
            bookService.savebooks(book);
            return "book saved with ID "+book.getBookId();
        }
        @PutMapping("/updatebooks/{bookId}")
         public String change(@PathVariable Long bookId, @RequestBody Books book)
         {
             bookService.updatebooks(bookId,book);
             return "The book with following id is updated with new values "+bookId;
         }

         @DeleteMapping("/deletebook/{bookId}")
         public String delete(@PathVariable Long bookId)
         {
           bookService.deletebooks(bookId);
             return "The book with following ID has been deleted: "+bookId;
         }


}
