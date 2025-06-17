package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// jdbc를 통해
		// 사번, 사원명, 직급명, 부서명, 급여, 보너스를 조회하여 
		// 출력문으로 출력해 확인
		
		// 1. 드라이버 등록 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		String id = "MULTI";
		String pw = "MULTI";
		
		Connection con = DriverManager.getConnection(url, id, pw);
		
		Statement stmt = con.createStatement();
		
		String query = "SELECT * FROM EMPLOYEE\r\n"
				+ "JOIN JOB USING(JOB_CODE)\r\n"
				+ "JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID)";
		
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println("사원 사원명 직급명 부서명   급여   보너스");
		while(rs.next()) {
			System.out.println(rs.getInt("EMP_ID")+" "+rs.getString("EMP_NAME")+" "
							 + rs.getString("JOB_NAME")+" "+rs.getString("DEPT_TITLE")+" "
							 + rs.getInt("SALARY")+" "+rs.getDouble("BONUS"));
		}
		
		
		// 5. 종료 
		rs.close();
		stmt.close();
		con.close();	
	}
}
