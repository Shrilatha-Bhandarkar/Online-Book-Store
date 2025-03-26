package com.onlinebookstore.books.controller;

import com.onlinebookstore.books.entity.Book;
import com.onlinebookstore.books.exception.BookNotFoundException;
import com.onlinebookstore.books.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // For managing book-related operations, provides end points for CRUD operations
				// on books.

@RequestMapping("/books")
public class BookController {

	// Logger instance for tracking and debugging application events
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	// Automatically injects BookService instance
	@Autowired
	private BookService bookService;

	// Adds a new book
	@PostMapping // Handles HTTP POST requests to add a new book
	public Book addBook(@RequestBody Book book) {
		// Logs the request to add a new book, including its title
		logger.info("Request to add a new book: {}", book.getTitle());
		return bookService.addBook(book);
	}

	// Retrieves all books
	@GetMapping // Handles HTTP GET requests to retrieve all books
	public List<Book> getAllBooks() {
		// Logs the request to fetch all books
		logger.info("Request to retrieve all books");
		return bookService.getAllBooks();
	}

	// Updates an existing book
	@PutMapping("/{id}") // Handles HTTP PUT requests to update an existing book
	public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		// Logs the request to update a book with its ID
		logger.info("Request to update book with ID: {}", id);
		return bookService.updateBook(id, updatedBook);
	}

	// Deletes a book by ID
	@DeleteMapping("/{id}") // Handles HTTP DELETE requests to remove a book by its ID
	public String deleteBook(@PathVariable Long id) {
		// Logs the request to delete a book by ID
		logger.info("Request to delete book with ID: {}", id);
		bookService.deleteBook(id);
		return "Book deleted successfully";
	}
	
	// Retrieves a book by ID
	@GetMapping("/{id}") // Handles HTTP GET requests to retrieve a book by its ID
	public Book getBookById(@PathVariable Long id) {
		// Logs the request to fetch a specific book by ID
		logger.info("Request to retrieve book with ID: {}", id);
		return bookService.getBookById(id)
				.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
	}
}