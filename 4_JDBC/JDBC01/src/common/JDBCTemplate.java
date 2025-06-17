package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 1. 연결
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Error] 드라이버 등록 실패!");
		}
		
		// 연결 jdbc:oracle:thin:@localhost:1521/orcl
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "MULTI";
		String pw = "MULTI";
		Connection con = null;
		
	try {
		con = DriverManager.getConnection(url, id, pw);
		con.setAutoCommit(false); 	// 자동커밋 끄겠다. 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("[Error] 오라클 연결 실패(url, id, pw)");
	}
		
		return con;
	}
	
	// 해제 
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] con close 실패");
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] stmt close 실패");
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] rs close 실패");
		}
	}
}
