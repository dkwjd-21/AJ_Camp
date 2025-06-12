package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.*;

public class JDBCTest04 {
	// insert
	public static void main(String[] args) throws SQLException {
		// 준비
		Connection con = null; 
		Statement stmt = null;
		
		// insert 실행에서는 ResultSet 필요없다. 
		int no = 1;
		String name = "Kang";
		String nickName = "Chani";
		
		// INSERT INTO MYTEST VALUES(1, 'Kang', 'Chani')
		String sql = "INSERT INTO MYTEST VALUES("+no+", '"
					+name+"', '"+nickName+"')";
		
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
	}

	
	
}
