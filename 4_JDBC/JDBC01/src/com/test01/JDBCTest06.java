package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class JDBCTest06 {

	public static void main(String[] args) throws SQLException {
		// PreaparedStatement 활용하여 insert
		
		// 준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		int no = 15; 
		String name = "YOON";
		String nickName = "yyyy";
		
		// Stirng sql = "INSERT INTO MYTEST VALUES(no+" 어쩌고")
		String sql = "INSERT INTO MYTEST VALUES(?, ?, ?)";
		
		// 연결
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);
		pstm.setString(2, name);
		pstm.setString(3, nickName);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("insert 성공");
//			con.commit();
//			con.rollback();
		}else {
			System.out.println("insert 실패");
		}
		
//		JDBCTest05.select();
		
		close(pstm);
		close(con);		
	}
}
