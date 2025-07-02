package com.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.member.dto.MemberDto;

public class MemberDao extends M_SqlMapConfig{
	String namespace = "com.member";
	
	public MemberDto selectOne(String id) {
		SqlSession session = null;
		MemberDto res = null;
		
		session = getSessionFactory().openSession(true);
		res = session.selectOne(namespace+".selectOne", id);
		
		session.close();
		
		return res;
	}
	
	// 회원가입
	public int signup(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.insert(namespace+".signup", dto);
		
		session.close();
		
		return res;
	}
	
	// 회원 탈퇴
	public int signout(int no) {
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory().openSession(true);
		res = session.update(namespace+".signout", no);
		
		session.close();
		
		return res;		
	}
}
