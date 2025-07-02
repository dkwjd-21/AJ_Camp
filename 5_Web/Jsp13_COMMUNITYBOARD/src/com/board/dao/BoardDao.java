package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;

public class BoardDao extends B_SqlMapConfig{
	String namespace = "com.board";
	
	// 글 전체보기
	public List<BoardDto> selectAll(){
		SqlSession session = null;
		List<BoardDto> list = null;
		
		session = getSessionFactory().openSession(true);
		list = session.selectList(namespace+".selectAll");
		
		return list;
	}
	
	// 글 하나만 보기
	public BoardDto selectOne(int no) {
		SqlSession session = null;
		BoardDto res = null;
		
		session = getSessionFactory().openSession(true);
		res = session.selectOne(namespace+".selectOne", no);
		
		session.close();
		
		return res;
	}
	
	// 글 작성
	public int insert(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.insert(namespace+".insert", dto);
		
		session.close();
		
		return res;
	}
	
	// 글 수정
	public int update(BoardDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.update(namespace+".update", dto);
		
		session.close();
		
		return res;		
	}
	
	// 글 삭제
	public int delete(int no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.delete(namespace+".delete", no);
		
		session.close();
		
		return res;
	}
}
