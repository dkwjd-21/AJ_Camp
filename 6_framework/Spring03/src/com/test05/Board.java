package com.test05;

public class Board {
	private String title; 
	private String content;
	private Member writer;
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
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return writer.toString()+", title: "+title+", content: "+content;
	}
	
	
}
