package com.test02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;

public class MyTestDao {
	public List<MyTestDto> getAll(Connection con){
		// 준비
		Statement stmt = null;
		ResultSet rs = null;
		List<MyTestDto> res = new ArrayList<>();
		String sql = "SELECT * FROM MYTEST";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyTestDto tmp = new MyTestDto();
				tmp.setMno(rs.getInt(1));
				tmp.setMname(rs.getString(2));
				tmp.setNickname(rs.getString(3));
				res.add(tmp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] select 에러!");
		} finally {
			close(rs);
			close(stmt);
		}
		
		return res;
	}
	
	public int insert(Connection con, MyTestDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "INSERT INTO MYTEST VALUES(?, ?, ?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getMno());
			pstm.setString(2, dto.getMname());
			pstm.setString(3, dto.getNickname());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				con.commit();
			}else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] insert 에러");
		}finally {
			close(pstm);
		}
		
		return res;
	}
	
	public int update(Connection con, MyTestDto dto) {
		// 준비
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "UPDATE MYTEST SET MNAME=?, NICKNAME=? WHERE MNO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMname());
			pstm.setString(2, dto.getNickname());
			pstm.setInt(3, dto.getMno());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				con.commit();
			}else {
				con.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] update 에러");
		}finally {
			close(pstm);
		}
		
		return res;
	}
	
	public int delete(Connection con, int mno) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "DELETE FROM MYTEST WHERE MNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			res = pstm.executeUpdate();
			
			if(res>0) {
				con.commit();
			}else {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] delete 에러");
		}finally {
			close(pstm);
		}
		
		
		return res;
	}
}

