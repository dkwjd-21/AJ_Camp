package com.collection.silsub1.controller;
import java.util.*;

import com.collection.silsub1.model.comparator.AscBoardNo;
import com.collection.silsub1.model.comparator.DescBoardNo;
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
		Board board = bd.displayOne(no);
		if(board == null) {
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.println(board);
		}		
	}
	
	public void updateTitle() {
		// 게시글 번호 입력받아 해당 게시글 출력
		System.out.println("제목을 수정할 게시글 번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		Board board = bd.displayOne(no);
		if(board == null) {
			System.out.println("수정하려는 글이 없습니다.");
		}else {
			System.out.println(board);
			System.out.println("제목을 입력하세요 : ");
			String title = sc.nextLine();
			// 수정작업
			bd.updateTitle(no, title);
			
//			if(title != null) {
//				board.setBoardTitle(title);
//				System.out.println("성공적으로 수정되었습니다.");
//				System.out.println(board);
//			}			
		}		
	}
	
	public void updateContent() {
		// 게시글 번호 입력받아 해당 게시글 출력
		System.out.println("내용을 수정할 게시글 번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		Board board = bd.displayOne(no);
		if(board == null) {
			System.out.println("수정하려는 글이 없습니다.");
		}else {
			System.out.println(board);
			System.out.println("내용을 입력하세요 : ");
			String content = sc.nextLine();
			// 수정작업
			bd.updateContent(no, content);
		}
	}
	
	public void deleteBoard() {
		// 게시글 번호 입력받아 해당 게시글 출력
		System.out.println("삭제할 게시글 번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		Board board = bd.displayOne(no);
		if(board == null) {
			System.out.println("삭제할 글이 없습니다.");
		}else {
			System.out.println(board);
			System.out.println("정말로 삭제하시겠습니까? (Y/N) : ");
			char res = sc.nextLine().toUpperCase().charAt(0);
			// 삭제 작업
			if(res == 'Y') {
				bd.deleteBoard(no);
			}else {
				System.out.println("삭제를 취소하였습니다.");
			}
			
		}
	}

	public void search() {
		// 검색할 게시글의 제목 입력
		System.out.println("검색할 제목 : ");
		String title = sc.nextLine();		
		
		// 검색
		ArrayList<Board> res = bd.search(title);
		if(res.size() == 0) {
			System.out.println("=========== 검색 결과 ===========");
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("=========== 검색 결과 ===========");
			for(Board b : res) {
				System.out.println(b);
			}
		}
	}
	
	public void sortList(int field, boolean isAsc) {
		// 매개변수
		
		// 정수값 : 어떤 필드를 정렬할지
		
		// 논리값 : true -> 오름차순, false -> 내림차순 
		
		List<Board> list = bd.displayAll();
		
		switch(field) {
		case 1:
			// 
			if(isAsc) {
				// true 일 때 
				// 오름차순 하겠다
				list.sort(new AscBoardNo());
			}else {
				// 내림차순 하겠다
				list.sort(new DescBoardNo());
			}
			break;
		}
		// 정렬 후 리스트 출력
		for(Board b : list) {
			System.out.println(b);
		}
	}
}
