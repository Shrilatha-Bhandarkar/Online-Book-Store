package com.onlinebookstore.books.exception;

// Exception thrown when a book is not found
public class BookNotFoundException extends RuntimeException {
    // Constructor with an error message
    public BookNotFoundException(String message) {
        super(message);
    }
}
