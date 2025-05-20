package com.test.chap04_constructor.test01;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		User u1 = new User();		// 기본 생성자
		u1.info();
		
		User u2 = new User("admin", "1234", "유리");
		u2.info();
		
		User u3 = new User("user01", "1234", "유리", new Date());
		u3.info();
		
		u1.setUserId("user02");
		u1.info();
	}

}
