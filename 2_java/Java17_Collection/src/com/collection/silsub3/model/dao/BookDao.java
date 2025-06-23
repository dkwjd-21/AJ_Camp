package com.collection.silsub3.model.dao;

import java.util.HashMap;
import java.util.Iterator;

import com.collection.silsub3.model.vo.Book;

public class BookDao {
	private HashMap<String, Book> bookMap = new HashMap<>();
	
	public BookDao() {}
	public BookDao(HashMap<String, Book> map) {
		// 외부에서 전달된 map으로 초기화 
		// 깊은 복사 (원본 보호 목적) 
		this.bookMap = new HashMap<>(map);
	}
	
	public int getLastBookNo() {
		Iterator<Book> it = bookMap.values().iterator();
		int lastKey = 0;
		
		while(it.hasNext()) {
			Book book = it.next();
			int tmp = book.getbNo();
		}
		
		return lastKey;		
	}
	
	public void addBook(Book book) {
		
	}
	
	public Book deleteBook(String key) {
		
	}
	
	public String searchBook(String title) {
		
	}
	
	public Book selectBook(String key) {
		
	}
	
	public HashMap<String, Book> selectAll(){
		
	}
	
	public ArrayList<Book> sortedBookList(){
		
	}
}


