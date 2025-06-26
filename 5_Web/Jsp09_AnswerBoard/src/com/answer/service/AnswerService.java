package com.answer.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.answer.dao.AnswerDao;
import com.answer.dto.AnswerDto;

public class AnswerService {
	AnswerDao dao = new AnswerDao();
	
	public List<AnswerDto> selectAll(){
		Connection con = getConnection();
		List<AnswerDto> res = dao.selectAll(con);
		
		close(con);
		System.out.println("05. db 종료");
		
		return res;		
	}
	
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		int res = dao.insert(con, dto);
		
		if(res>0) {
			commit(con);
		} else {
			rollback(con);
		}
		System.out.println("05. db 종료");
		
		return res;
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		AnswerDto res = dao.selectOne(con, boardno);
		
		if(res!=null) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		System.out.println("5. db 종료");
		
		return res;
	}
}
