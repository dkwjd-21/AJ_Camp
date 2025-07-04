package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		// Emp 클래스를 이용하여 bean 2개 생성
		// 하나는 생성자를 통해, 하나는 setter를 통해
		// 초기화 하며 빈이 생성되고, 
		// 생성된 빈을 main에서 getBean으로 확인
		
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp kang = factory.getBean("kang", Emp.class);
		Emp park = (Emp)factory.getBean("park");
		
		
		System.out.println(kang.toString());
		System.out.println(park.toString());
	}
}

