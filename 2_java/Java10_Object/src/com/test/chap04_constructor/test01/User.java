package com.test.chap04_constructor.test01;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date date;
	
	
	
	// 기본생성자 : 필드 초기화 역할은 수행하지 못함. 객체를 생성할 때 사용됨
	// 이름은 반드시 클래스명과 동일해야 한다. 
	public User() {
		System.out.println("기본 생성자 실행");
	}
	
	// 매개변수가 있는 생성자 : 객체 생성과 필드 초기화 두 가지 목적으로 사용
	// 같은 이름, 다른 매개변수 -> 오버로딩을 통해 구현 
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName, Date date) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		
		// this() : 해당 클래스 내의 다른 생성자 호출
		this(userId, userPwd, userName);
		this.date = date;
	}
	
	// setter 메소드 : 필드에 값을 저장하는 메소드 
	public void setUserId(String userId) {
		this.userId = userId;
	}
	// getter 메소드 : 필드에 저장된 값을 불러오는 메소드
	public String getUserId() {
		return userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	
	
	// 출력용 메소드
	public void info() {
		System.out.println(userId+", "+userPwd+","+userName+", "+date);
	}
}
