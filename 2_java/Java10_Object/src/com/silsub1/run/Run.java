package com.silsub1.run;

import com.silsub1.model.Member;

public class Run {

	public static void main(String[] args) {
		Member m = new Member();
		
		m.setMemberId("yuri");
		m.setMemberPwd("1234");
		m.setMemberName("유리");
		m.setAge(24);
		m.setGender('F');
		m.setEmail("dkwjd4774@naver.com");
		m.setPhone("010-1234-1234");
		
		System.out.println("ID: "+m.getMemberId());
		System.out.println("PW: "+m.getMemberPwd());
		System.out.println("NAME: "+m.getMemberName());
		System.out.println("AGE: "+m.getAge());
		System.out.println("GENDER: "+m.getGender());
		System.out.println("EMAIL: "+m.getEmail());
		System.out.println("PHONE: "+m.getPhone());
	}

}
