package com.bookstore.books.controllers;

import com.bookstore.books.models.Category;
import com.bookstore.books.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }


    @GetMapping("/category/{categoryID}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryID) {
        return categoryService.getCategory(categoryID);
    }

    @PutMapping("/category/{categoryID}")
    public void updateCategory(@RequestBody Category category, @PathVariable Long categoryID) {

        categoryService.updateCategory(category, categoryID);
    }

    @DeleteMapping("/category/{categoryID}")
    public void deleteCategory(@PathVariable Long categoryID) {

        categoryService.deleteCategory(categoryID);
    }
}
