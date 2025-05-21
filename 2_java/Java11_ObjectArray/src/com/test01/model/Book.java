package com.test01.model;

public class Book {
	// 필드
	private String title;
	private String writer;
	private String publisher;
	private int price;
	
	// 생성자
	// 기본 생성자
	public Book() { }
	// 매개변수 생성자
	public Book(String title, String writer, String publisher, int price) {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	// 메소드
	// getter & setter
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	// 필드값을 출력하는 메소드
	public String info() {
		String str = "제 목 : "+title+"\n저 자 : "+writer
					+"\n출판사 : "+publisher+"가 격 : "+price+"원";
		return str;
	}
}
