package com.collection.silsub1.controller;
import java.util.*;

import com.collection.silsub1.model.dao.BoardDao;
import com.collection.silsub1.model.vo.Board;

public class BoardController {
	private BoardDao bd = new BoardDao();
	private Scanner sc = new Scanner(System.in);
	
	public void write() {
		// 게시글 작성 및 추가 
		System.out.println("[새 게시물 쓰기]");
		
		System.out.println("글 제목: ");
		String title = sc.nextLine();
		System.out.println("작성자: ");
		String writer = sc.nextLine();
		System.out.println("내용: ");
		String content = "";
		String str = "";
		
		while(true) {
			str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			content += str;
		}
		
		try {
			Board b = new Board(bd.getLastNo()+1, title, writer, new Date(), content);
			bd.write(b);
		} catch (IndexOutOfBoundsException e) {
			// 해당 예외가 발생하는 경우
			// list에 객체가 하나도 없을 경우 발생
			Board b = new Board(1, title, writer, new Date(), content);
			bd.write(b);
		}
		
	}

	public void displayAll() {
		List<Board> list = bd.displayAll();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void saveList() {
		bd.saveList();
	}
	
	public void displayOne() {
		// 게시글 번호 입력받아 해당 게시글 출력
		System.out.println("확인할 게시글 번호를 입력하세요 : ");
		int no = sc.nextInt();
		Board b = bd.displayOne(no);
		System.out.println(b);
	}
}
