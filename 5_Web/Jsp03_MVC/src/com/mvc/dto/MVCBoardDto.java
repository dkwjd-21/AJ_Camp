package com.mvc.dto;
/*
CREATE SEQUENCE SEQ_MVCBOARD NOCACHE;
CREATE TABLE MVCBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(100) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MVCBOARD
VALUES(SEQ_MVCBOARD.NEXTVAL, '관리자', '테스트 중', '테스트 1234 ABCDE', '22/02/22');

SELECT * FROM MVCBOARD;
 * */

import java.util.Date;

public class MVCBoardDto {
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	public MVCBoardDto() {}

	public MVCBoardDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
