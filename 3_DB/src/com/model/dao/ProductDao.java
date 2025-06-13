package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;
import com.model.dto.Product;

public class ProductDao {
	public List<Product> selectAll(Connection con){
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Product> res = new ArrayList<>();
		String sql = "SELECT * FROM PRODUCT";
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				res.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] selectAll 에러!!");
		} finally {
			close(rs);
			close(pstm);
		}		
		return res;
	}
	public Product selectOne(Connection con, String id) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product res = null; 
		String sql = "SELECT * FROM PRODUCT WHERE P_ID =?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				res = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[Error] selectOne 에러");
		} finally {
			close(rs);
			close(pstm);
		}
		
		return res;
	}
	
	public int insert(Connection con, Product dto) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getPid());
			pstm.setString(2, dto.getPname());
			pstm.setInt(3, dto.getPrice());
			pstm.setString(4, dto.getDes());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] insert 에러!");
		}
		
		return res;
	}
	public int update(Connection con, Product dto) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "UPDATE PRODUCT SET PRICE=? WHERE P_ID=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getPrice());
			pstm.setString(2, dto.getPid());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] update 에러!");
		}
		return res;
	}	
	public int delete(Connection con, String id) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "DELETE FROM PRODUCT WHERE P_ID=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] delete 에러!");
		}
		return res;
	}
}
