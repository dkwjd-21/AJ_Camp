package com.test01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 1. 드라이버 등록 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ex) mySql - com.cj.mySql.jdbc.Driver
		
		// 2. dbms 연결
		// connection 객체 생성 
		// url, id, pw 값 필요하다. 
		// 		url : 어디에 있는 db랑 연결할지
		// 		id : 어떤 계정이랑 연결할지
		//		pw : 해당 계정의 비밀번호 
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		// localhost == 127.0.0.1
		String id = "MULTI";
		String pw = "MULTI";
		
		// DBMS 와 연결
		Connection con = DriverManager.getConnection(url, id, pw);
		
		// 3. sql 실행 및 결과처리 
		Statement stmt = con.createStatement();
		
		// 쿼리문 실행 
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)");
		
		// 결과처리 
		while(rs.next()) {
			System.out.println(rs.getInt("EMP_ID")+" "+rs.getString(2)+" "+rs.getInt("SALARY")+
								" "+rs.getString("DEPT_TITLE"));
		}
		
		// 5. 종료 
		rs.close();
		stmt.close();
		con.close();		
	}

}
