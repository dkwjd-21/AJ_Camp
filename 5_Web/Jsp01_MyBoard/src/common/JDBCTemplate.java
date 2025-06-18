package common;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	// 연결
	public static Connection getConnection() {
		// 1. driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 등록");
		} catch (ClassNotFoundException e) {
			System.out.println("[Error] 드라이버 등록 실패");
			e.printStackTrace();
		}
		
		// 2. db 연결 
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "MULTI";
		String pw = "MULTI";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("2. DB 연결");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("[Error] DB연결 실패");
			e.printStackTrace();
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
		}		
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 저장
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 취소
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
