package com.example.librarysystem.Services.ServiceImpl;

import com.example.librarysystem.Exception.ResourceNotFoundException;
import com.example.librarysystem.Models.Books;
import com.example.librarysystem.Repository.BookRepository;
import com.example.librarysystem.Services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Transactional annotation is added by spring boot
@Service
public class BooksServiceImpl implements BookService{
    private BookRepository bookRepository;

    //on adding the constructor with args, needn't write @Autowired annotation. Spring boot handles it
    public BooksServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books savebooks(Books book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Books> getAllbooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books findBooksByAuthor(String author) {
       Books book= bookRepository.findBooksByAuthor(author);
       if(book==null) {
           throw new ResourceNotFoundException("Author not found");
       }
       return book;
    }

    @Override
    public Long count() {
        return bookRepository.count();
    }

    @Override
    public Books updatebooks(Long id, Books book) {
        Books updated_book=bookRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Book id not found with id "+id));
        updated_book.setAuthor(book.getAuthor());
        updated_book.setBookName(book.getBookName());
        updated_book.setBookType(book.getBookType());
        updated_book.setBookPublished(book.getBookPublished());
        bookRepository.save(updated_book);
        return updated_book;
    }

    @Override
    public Books deletebooks(Long id) {
        Books delete_book= bookRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Book id not found with id "+id)
        );
        bookRepository.delete(delete_book);
        return delete_book;
    }

}
