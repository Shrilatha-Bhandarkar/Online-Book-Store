package com.onlinebookstore.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.books.entity.Book;

@Repository // Repository interface for Book entity.

public interface BookRepository extends JpaRepository<Book, Long> {
	//Extends JpaRepository to provide built-in CRUD operations.
}