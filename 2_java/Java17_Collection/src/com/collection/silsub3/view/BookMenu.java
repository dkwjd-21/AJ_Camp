package com.collection.silsub3.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.collection.silsub3.controller.BookManager;
import com.collection.silsub3.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();
	
	public BookMenu() {}
	
	public void mainMenu() {
		while(true) {
			System.out.println("**** 도서 관리 프로그램 ****");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			System.out.println("메뉴 번호 선택 : ");
			String menu = sc.nextLine();
			
			switch(menu) {
				case "1":
					// addBook (inputBook()이 리턴한 객체) 실행
					bm.addBook(inputBook());
					break;
				case "2":
					// sortedBookList() 실행
					// => Book[] 리턴 받아 printBookList(Book[]) 실행
					Book[] br = bm.sortedBookList();
					bm.printBookList(br);
					break;
				case "3":
					// deleteBook (inputBookNo()이 리턴한 도서 번호) 실행
					// => Book 리턴 받아 null이 아닐 경우 “성공적으로 삭제”
					//	  null일 경우 “삭제할 글이 존재하지 않음”
					Book book = bm.deleteBook(inputBookNo());
					if(book != null) {
						System.out.println("성공적으로 삭제");
					} else {
						System.out.println("삭제할 글이 존재하지 않음");
					}
					break;
				case "4":
					// searchBook (inputBookTitle()이 리턴한 도서 제목) 실행
					// => key 리턴 받아 null일 경우 “조회한 글이 존재하지 않음”
					//	  null이 아닐 경우 selectBook(key) 출력
					String key = bm.searchBook(inputBookTitle());
					if(key==null) {
						System.out.println("조회한 글이 존재하지 않음");
					} else {
						System.out.println(bm.selectBook(key).toString());
					}
					break;
				case "5":
					// selectAll() 실행
					// => 결과 map 리턴 받아 비어있을 경우 “없습니다.”
					//	  아닐 경우 Iterator, keySet()을 이용하여 전체 출력
					HashMap<String, Book> books = bm.selectAll();
					if(books.isEmpty()) {
						System.out.println("없습니다.");
					} else {
						Iterator<String> it = books.keySet().iterator();
						while(it.hasNext()) {
							String key = it.next();        // key 하나 꺼냄
						    Book value = books.get(key);   // key로 value 꺼냄
						    System.out.println(key + " : " + value);
						}
					}
					break;			
					
				case "6":
					System.out.println("[프로그램 종료]");
					return;
			}
		}
	}
	
	public Book inputBook() {
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		System.out.println("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.println("도저 저자 : ");
		String author = sc.nextLine();
		
		Book book = new Book(category, title, author);
		
		return book;
	}
	
	public String inputBookNo() {
		System.out.println("도서 번호 : ");
		String bNo = sc.nextLine();
		
		return bNo;
	}
	
	public String inputBookTitle() {
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		
		return title;		
	}
}
