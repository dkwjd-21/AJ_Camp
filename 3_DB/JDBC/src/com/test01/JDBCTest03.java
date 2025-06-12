package com.test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static common.JDBCTemplate.*;

public class JDBCTest03 {

	public static void main(String[] args) throws SQLException {
		// 준비 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DEPARTMENT";
		
		// 연결
		con = getConnection();
		
		// 쿼리 실행 및 결과 처리
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t["+rs.getString(3)+"]");
		}
		
		close(rs);
		close(stmt);
		close(con);
	}

}
