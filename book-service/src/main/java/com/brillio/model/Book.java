package com.brillio.model;



import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book")
public class Book {

	@org.springframework.data.annotation.Id	
	private int bookId;
	private String name;
	private String bookAuthor;
	private double bookPrice;
	public Book(int bookId, String name, String bookAuthor, double price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.bookAuthor = bookAuthor;
		this.bookPrice = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getPrice() {
		return bookPrice;
	}
	public void setPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	

}
