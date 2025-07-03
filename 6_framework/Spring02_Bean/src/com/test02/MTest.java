package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 김창진, 서울시 강남구, 010-1111-1111
		// 박창진, 경기도 수원시, 010-2222-2222
		// 위와 같은 값으로 초기화된 빈을 생성하여 main에서 확인
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address kim = (Address)factory.getBean("kim");
		System.out.println(kim.toString());
		
		Address park = (Address)factory.getBean("park");
		System.out.println(park.toString());
	}
}
