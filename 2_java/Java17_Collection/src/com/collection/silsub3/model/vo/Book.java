package com.collection.silsub3.model.vo;

public class Book implements Comparable<Book>{
	private String bNo;
	private int category;
	private String title;
	private String author;
	
	public Book() {}

	public Book(int category, String title, String author) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bNo=" + bNo + ", category=" + category + ", title=" + title + ", author=" + author + "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());
	}	
	
}
