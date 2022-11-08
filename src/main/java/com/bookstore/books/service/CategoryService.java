package com.bookstore.books.service;

import com.bookstore.books.models.Books;
import com.bookstore.books.models.Category;
import com.bookstore.books.repos.BookRepo;
import com.bookstore.books.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public ResponseEntity<?> getAllCategories() {
        Iterable<Category> allCategories = categoryRepo.findAll();
        return new ResponseEntity<>(categoryRepo.findAll(), HttpStatus.OK);
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public ResponseEntity<?> getCategory(Long categoryID) {
        Optional<Category> b = categoryRepo.findById(categoryID);
        return new ResponseEntity<> (b, HttpStatus.OK);
    }

    public ResponseEntity<?> updateCategory(Category category, Long categoryID) {
        categoryRepo.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategory(Long categoryID) {
        categoryRepo.deleteById(categoryID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
