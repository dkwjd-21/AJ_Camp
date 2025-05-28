package com.collection.silsub1.model.dao;

import java.io.*;
import java.util.*;

import com.collection.silsub1.model.vo.Board;

// dao(Data Access Object) : 데이터에 접근하는 역할
public class BoardDao {
	private ArrayList<Board> list = new ArrayList<Board>();
	public BoardDao() {
		// 객체 생성시 board.txt로부터 저장된 데이터 입력받기 
		// 그렇게 input 받은 데이터를 list에 추가
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("board.txt"))){
			while(true) {
				list.add( (Board)(oi.readObject()) );
			}
			// 종료되는 조건이 없는 while이기에
			// End of File 까지 반복
		}catch(EOFException e) {
			System.out.println("[실행 준비 완료]");
			return;
		}catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
				
	}
	
	// list에 저장된 게시글 중 마지막 게시글의 번호를 리턴
	public int getLastNo() {
		return list.get(list.size()-1).getBoardNo();
	}
	
	// 게시글 저장
	public void write(Board board) {
		list.add(board);
	}
	
	// 게시글 전체 확인
	public List displayAll() {
		return list;
	}
	
	// 파일에 list 저장
	public void saveList() {
		// ObjectOutputStream
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("board.txt"))){
			// 출력 write
			for(int i=0; i<list.size(); i++) {
				// board 객체 하나씩 board.txt에 출력
				os.writeObject(list.get(i));
			}
			System.out.println("board.txt에 저장 완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 게시글 한 개 보기
	public Board displayOne(int no) {
		// 매개변수로 넘어온 게시글 번호와 일치하는 게시글 찾기
		Board board = null;
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				board = list.get(i);
				break;
			}
		}
		return board;
	}
	
	// 제목 수정
	public void updateTitle(int no, String title) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.get(i).setBoardTitle(title);
				System.out.println("성공적으로 수정되었습니다.");
				System.out.println(list.get(i));
				break;
			}				
		}
	}
	
	// 내용 수정
	public void updateContent(int no, String content) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.get(i).setBoardContent(content);
				System.out.println("성공적으로 수정되었습니다.");
				System.out.println(list.get(i));
				break;
			}				
		}
	}
	
	// 게시글 삭제
	public void deleteBoard(int no) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo() == no) {
				list.remove(i);
				break;
			}				
		}	
		System.out.println("성공적으로 삭제되었습니다.");
	}
	
	// 게시글 검색
	public ArrayList<Board> search(String title) {
		// 검색 결과가 다층일 수 있으니 리스트에 담아 리턴 
		ArrayList<Board> res = new ArrayList<>();
		
		// 탐색
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardTitle().contains(title)) {
				res.add(list.get(i));
			}
		}
		
		return res;
	}
}
