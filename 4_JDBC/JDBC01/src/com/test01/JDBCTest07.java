package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class JDBCTest07 {

	public static void main(String[] args) throws SQLException {
		// 이름을 입력받아 삭제 
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		String sql = "DELETE FROM MYTEST WHERE MNAME=?";
		
		String name = new Scanner(System.in).next();
		
		con = getConnection();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, name);
		
		int res = pstm.executeUpdate();
		if(res>0) {
			System.out.println("삭제 성공!");
			con.commit();
		}else {
			System.out.println("삭제 실패 or 삭제할 데이터가 없습니다.");
			con.rollback();
		}
		
		close(pstm);
		close(con);			
	}

}
