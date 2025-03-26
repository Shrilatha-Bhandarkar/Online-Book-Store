package com.onlinebookstore.books.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // Marks this class as a JPA entity
public class Book {
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID value.
	private Long id;

	private String title;
	private String author;
	private BigDecimal price;
	private LocalDate publishedDate;

	// Getters and Setters
	//Gets the ID of the book.
	public Long getId() {
		return id;
	}

	//Sets the ID of the book.
	public void setId(Long id) {
		this.id = id;
	}

	//Gets the title of the book.
	public String getTitle() {
		return title;
	}

	//Sets the title of the book.
	public void setTitle(String title) {
		this.title = title;
	}

	//Gets the author of the book.
	public String getAuthor() {
		return author;
	}

	//Sets the author of the book.
	public void setAuthor(String author) {
		this.author = author;
	}

	//Gets the price of the book.
	public BigDecimal getPrice() {
		return price;
	}

	//Sets the price of the book.
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	//Gets the published date of the book.
	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	//Sets the published date of the book.
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
}