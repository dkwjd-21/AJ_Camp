package com.test.part02_OberridingTest.Book;

public class Book {
	// 필드
	private String title;
	private String writer;
	private int price;
	
	// 생성자
	public Book() {}
	public Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	// get & set
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			// 두 객체의 주소가 같으면 같다.
			return true;
		}
		if(obj == null) {
			// 비교할 객체가 비어져있음 
			return false;
		}
		
		// 전달받은 객체의 필드값과 현재 객체의 필드값을 비교
		Book other = (Book)obj;				// 형변환
		
		// 원본의 제목이 null 이면 배교할 객체의 제목도 null이어야 한다.
		// 그렇지 않을 경우를 찾아서 false를 리턴한다. 
		if(this.title == null) {
			if(other.title !=null) {
				return false;
			}
		}
		// 두 객체의 title 값이 다른 경우를 찾아서 false를 리턴한다. 
		else if(!title.equals(other.title)) {
			return false;
		}
		
		if(writer == null) {
			if(other.writer != null) {
				return false;
			}				
		}
		else if(!writer.equals(other.writer)){
			return false;
		}
		
		if(price != other.price) {
			return false;
		}
		
		// 모든 조건을 통과하면 두 객체는  같은 객체다. 
		return true;
	}
	
	@Override
	public int hashCode() {
		// 내용이 같으면 같은 해시코드를 출력한다. 
		return (title+writer+price).hashCode();
	}
	
}
