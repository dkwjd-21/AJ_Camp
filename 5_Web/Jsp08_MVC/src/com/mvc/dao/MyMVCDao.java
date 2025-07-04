package com.mvc.dao;

import java.sql.Connection;
import java.util.List;

import com.mvc.dto.MyMVCDto;

public interface MyMVCDao {
	String selectAllSql = " SELECT * FROM MYMVCBOARD ORDER BY SEQ ";
	String selectOneSql = " SELECT * FROM MYMVCBOARD WHERE SEQ=? ";
	String insertSql = " INSERT INTO MYMVCBOARD VALUES(SEQ_MYMVCBOARD.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String updateSql = " UPDATE MYMVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
	String deleteSql = " DELETE FROM MYMVCBOARD WHERE SEQ=? ";
	
	public List<MyMVCDto> selectAll(Connection con);
	public MyMVCDto selectOne(Connection con, int seq);
	public boolean insert(Connection con, MyMVCDto dto);
	public boolean update(Connection con, MyMVCDto dto);
	public boolean delete(Connection con, int seq);	
}
