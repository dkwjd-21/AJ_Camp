package com.collection.silsub3.controller;

import com.collection.silsub3.model.vo.Book;

public class BookManager {
	public BookManager() {}
	
	public void addBook(Book book) {
		// BookDao의 getLastBookNo() 메소드를 통해 도서의 마지막 도서 번호를 알아옴
		
		// 첫 글일 경우 0으로 받아오게끔 BookDao의 getLastBookNo() 내용 구현 할 것!
		
		// setter를 이용하여 도서 번호를 마지막 도서 번호 +1 처리
		
		// BookDao의 addBook()메소드에 해당 Book 객체 전달
	}
	
	public Book deleteBook(String key) {
		// BookDao의 deleteBook() 메소드에 전달받은 도서 번호 전달
		
		
		// 그 결과 값을 받아 리턴
	}
	
	public String searchBook(String title) {
		
	}
	
	public Book selectBook(String key) {
		
	}
	
	public HashMap<String, Book> selectAll(){
		
	}
	
	public Book[] sortedBookList() {
		
	}
	
	public void printBookList(Book[] br) {
		
	}
}
