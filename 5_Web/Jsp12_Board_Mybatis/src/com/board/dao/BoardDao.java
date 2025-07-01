package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends SqlMapConfig{
	String namespace = "com.my.board";
	
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> res = null;
		
		session = getSessionFactory().openSession(true);
		res = session.selectList(namespace+".selectAll");
		
		session.close();
	
		return res;
	}
	
	public BoardDto selectone(int seq) {
		SqlSession session = null;
		BoardDto dto = null;
		
		session = getSessionFactory().openSession(true);
		dto = session.selectOne(namespace+".selectOne", seq);
		
		session.close();
		
		return dto;		
	}
	
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(false);
		res = session.update(namespace+".update", dto);
		
		if(res>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return res;
		
	}
	
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.insert(namespace+".insert", dto);
		
		session.close();
		
		return res;
	}
	
	public int mulDel(String[] seq) {
		SqlSession session = null;
		int res = 0;
		
		Map<String, String[]> map = new HashMap<>();
		map.put("seq", seq);
				
		session = getSessionFactory().openSession(false);
		res = session.delete(namespace+".muldel", map);
		
		if(res == seq.length) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return res;
	}
	
	public int delete(int seq) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(false);
		res = session.delete(namespace+".delete", seq);
		
		if(res>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return res;
	}
}
