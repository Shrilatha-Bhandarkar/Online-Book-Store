package com.onlinebookstore.books.service;

import com.onlinebookstore.books.entity.Book;
import com.onlinebookstore.books.exception.BookNotFoundException;
import com.onlinebookstore.books.repository.BookRepository;
import com.onlinebookstore.books.util.MetricsConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component
public class BookService {

	// Logger instance for tracking and debugging service layer events
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired // Injects the BookRepository dependency
	private BookRepository bookRepository;

	// Adds a new book to the repository
	public Book addBook(Book book) {
		// Metrics tracking for performance monitoring
		MetricsConfig metrics = new MetricsConfig("addBook"); // Start tracking
		try {
			// Logs the request to save a new book, including its title
			logger.info("Saving book: {}", book.getTitle());
			return bookRepository.save(book);
		} finally {
			// Stops the metrics tracking once operation is complete
			metrics.stop(); // Stop tracking
		}
	}

	// Retrieves all books from the repository
	public List<Book> getAllBooks() {
		// Metrics tracking for performance monitoring
		MetricsConfig metrics = new MetricsConfig("getAllBooks"); // Start tracking
		try {
			// Logs the retrieval request for all books
			logger.info("Retrieving all books");
			List<Book> books = bookRepository.findAll(); // Fetch all books
			// Logs the number of books retrieved
			logger.info("Fetched {} books", books.size()); // Log the number of books fetched
			return books;
		} finally {
			// Stops the metrics tracking once operation is complete
			metrics.stop(); // Stop tracking
		}
	}

	// Retrieves a book by its ID
	public Optional<Book> getBookById(Long id) {
		// Metrics tracking for performance monitoring
		MetricsConfig metrics = new MetricsConfig("getBookById"); // Start tracking
		try {
			// Logs the request to find a book with the given ID
			logger.info("Looking for book with ID: {}", id);
			return bookRepository.findById(id);
		} finally {
			// Stops the metrics tracking once operation is complete
			metrics.stop(); // Stop tracking
		}
	}

	// Updates an existing book
	public Book updateBook(Long id, Book updatedBook) {
		// Metrics tracking for performance monitoring
		MetricsConfig metrics = new MetricsConfig("updateBook");
		try {
			// Logs the request to update a book
			logger.info("Updating book with ID: {}", id);
			// Fetches the existing book or throws an exception if not found
			Book existingBook = bookRepository.findById(id)
					.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

			// Update the existing book
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			existingBook.setPrice(updatedBook.getPrice());
			existingBook.setPublishedDate(updatedBook.getPublishedDate());

			// Logs the successful update action
			logger.info("Book with ID {} updated successfully", id);
			return bookRepository.save(existingBook); // Save updated book
		} finally {
			// Stops the metrics tracking once operation is complete
			metrics.stop(); // Stop tracking
		}
	}

	// Deletes a book by its ID
	public void deleteBook(Long id) {
		// Metrics tracking for performance monitoring
		MetricsConfig metrics = new MetricsConfig("deleteBook"); // Start tracking
		try {
			// Logs the request to delete a book
			logger.info("Deleting book with ID: {}", id);
			// Checks if the book exists before attempting to delete
			if (!bookRepository.existsById(id)) {
				throw new BookNotFoundException("Book not found with ID: " + id);
			}

			bookRepository.deleteById(id);
			// Logs successful deletion
			logger.info("Book with ID {} deleted successfully", id);
		} finally {
			// Stops the metrics tracking once operation is complete
			metrics.stop(); // Stop tracking
		}
	}
}