package com.test01;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest05 {
	
	
	public static void main(String[] args) throws SQLException {
		// [1] insert
		// Scanner를 이용하여 번호, 이름, 별명을 입력받아
		// MYTEST 테이블에 저장. 
		
		// [2] select
		// 그리고 저장 후 조회해서 콘솔에 출력. 
		Scanner sc = new Scanner(System.in);
		int no = 0;
		do {
			System.out.println("--- 메뉴 ---");
			System.out.println("1. 추가");
			System.out.println("2. 조회");
			System.out.println("3. 종료");
			System.out.println("번호 입력: ");
			no = sc.nextInt();
			
			switch(no) {
			case 1: 
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.println("프로그램 종료");
				return;
			}
		}while(true);
	}	
	
	public static void insert() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("번호를 입력하세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.println("별명을 입력하세요 : ");
		String nickName = sc.nextLine();
		// INSERT INTO MYTEST VALUES(1, 'Kang', 'Chani')
		String sql = "INSERT INTO MYTEST VALUES("+no+", '"
					+name+"', '"+nickName+"')";
		
		// 준비
		Connection con = null; 
		Statement stmt = null;
		// 연결
		con = getConnection();
		// 쿼리 실행 및 결과 처리 
		stmt = con.createStatement();
		
		// 적용된 로우의 수를 int 값으로 리턴
		int res = stmt.executeUpdate(sql);
				
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		close(con);
		close(stmt);
	}
	
	public static void select() throws SQLException {
		// 준비
		Connection con = null; 
		Statement stmt = null;
		ResultSet rs = null;
		// 연결
		con = getConnection();
		// 쿼리 실행 및 결과 처리 
		stmt = con.createStatement();
		
		String sql = "SELECT * FROM MYTEST";
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		close(con);
		close(stmt);
		close(rs);	
	}
}
