package com.example.librarysystem.Controller;
import com.example.librarysystem.Exception.ResourceNotFoundException;
import com.example.librarysystem.Models.Books;
import com.example.librarysystem.Models.User;
import com.example.librarysystem.Services.BookService;
import com.example.librarysystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
        @GetMapping("/")
        public ResponseEntity<String> newPage()
        {
            return new ResponseEntity<>("Welcome to library management system",HttpStatus.OK);
        }
        @GetMapping({"/books"})
        public ResponseEntity<List<Books>> getbooks()
        {
            List<Books> listBooks=bookService.getAllbooks();
            return new ResponseEntity<>(listBooks, HttpStatus.OK);
        }
        @GetMapping("/countbooks")
        public ResponseEntity<String> count()
        {
            Long val=bookService.count();
            return new ResponseEntity<>("The number of books in the library are "+val,HttpStatus.OK);
        }
        @GetMapping("/books/{author}")
        public ResponseEntity<Books> search(@PathVariable String author)
        {
           Books bookAuthor=bookService.findBooksByAuthor(author);
           return new ResponseEntity<>(bookAuthor,HttpStatus.OK);
        }
        @PostMapping("/addbooks")
        public ResponseEntity<String> add(@RequestBody Books book)
        {
            Books bookAdded=bookService.savebooks(book);
            return new ResponseEntity<>("The book is added with the id "+bookAdded.getBookId(),HttpStatus.CREATED);
        }
        @PutMapping("/updatebooks/{bookId}")
         public ResponseEntity<String> change(@PathVariable Long bookId, @RequestBody Books book)
         {
             Books bookChanged= bookService.updatebooks(bookId,book);
             return new ResponseEntity<>("The book with following id is updated with new values "+bookId+"\n"+bookChanged,HttpStatus.OK);
         }
         //getting book and user by their ids
         @PutMapping("/user/{userId}/books/{bookId}")
         public ResponseEntity<Books> assignUsertoBooks (@PathVariable Long bookId,@PathVariable Long userId)
         {
             User user = userService.findById(userId);
             Books book = bookService.findById(bookId);
             book.assign(user);
             bookService.updatebooks(bookId, book);
             return new ResponseEntity<>(book, HttpStatus.CREATED);
         }
         @DeleteMapping("/deletebook/{bookId}")
         public ResponseEntity<String> delete(@PathVariable Long bookId)
         {
           bookService.deletebooks(bookId);
             return new ResponseEntity<>("The book with following ID has been deleted: "+bookId,HttpStatus.OK);
         }


}
