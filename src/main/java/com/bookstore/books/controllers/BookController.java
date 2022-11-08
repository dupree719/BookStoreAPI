package com.bookstore.books.controllers;

import com.bookstore.books.models.Books;
import com.bookstore.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books/{categoryID}/books")
    public void createBook(@PathVariable (value = "categoryID") Long categoryID, @Validated @RequestBody Books books) {
        bookService.createBook(categoryID, books);
    }



    @GetMapping("/books/{bookID}")
    public ResponseEntity<?> getBook(@PathVariable Long bookID) {
        return bookService.getBook(bookID);
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBook(@RequestBody Books books, @PathVariable Long bookID) {

        bookService.updateBook(books, bookID);
    }

    @DeleteMapping("/books/{bookID}")
    public void deleteBook(@PathVariable Long bookID) {

        bookService.deleteBook(bookID);

    }
    @GetMapping("/searchBooks")
    public Iterable<Books> searchForBookByName(@RequestParam("search") String search){
        return bookService.searchForBookByName(search);
    }
//    @GetMapping("/books/{categoryId}/books")
//    public Iterable<Books> getAllBooksFromCategory(@PathVariable Long categoryID){
//        return bookService.findByCategoryID(categoryID);
//    }

}
