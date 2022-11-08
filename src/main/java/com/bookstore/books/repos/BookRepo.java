package com.bookstore.books.repos;

import com.bookstore.books.models.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepo extends CrudRepository<Books, Long> {

    Iterable<Books> findByCategoryId(Long categoryId);
    @Query(value = "Select * From books WHERE title LIKE CONCAT('%', :search, '%')", nativeQuery = true)
    Iterable<Books> searchForBooksByName(String search);
}
