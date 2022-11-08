package com.bookstore.books.service;

import com.bookstore.books.models.Books;
import com.bookstore.books.repos.BookRepo;
import com.bookstore.books.repos.CategoryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    private static final Logger log = LoggerFactory.getLogger(BookService.class);


    //Endpoint needed to get all the books in the book store via "/books"
    public Iterable<Books> getAllBooks() {
       return bookRepo.findAll();
    }

    //Endpoint needed to create a book via "/books/{categoryId}/books"
    public void createBook(Long categoryId, Books books){
        categoryRepo.findById(categoryId).map(category ->{
            books.setCategory(category);
            return bookRepo.save(books);
        });
    }

    //Endpoint needed to get a single book via "/books/id"
    public ResponseEntity<?> getBook(Long bookID) {
        Books b = bookRepo.findById(bookID).orElse(null);
        return new ResponseEntity<> (b, HttpStatus.OK);
    }

    //Endpoint needed to update a book via "/books/{categoryId}/books"
    public ResponseEntity<?> updateBook(Books books, Long categoryID) {
        bookRepo.save(books);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Endpoint needed to delete a book via "/books/id"
    public ResponseEntity<?> deleteBook(Long bookID) {
        bookRepo.deleteById(bookID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    public Iterable<Books> findByCategoryID(Long categoryID){
//        return bookRepo.getAllBooksFromCategory(categoryID);

public Iterable<Books> searchForBookByName(String search){
    return bookRepo.searchForBooksByName(search);
}

}

