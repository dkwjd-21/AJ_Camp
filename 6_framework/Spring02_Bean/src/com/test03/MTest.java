package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// 홍길동, 90, 70, 50
		// 김길동, 80, 50, 20
		// 최길동, 60
		// 박길동
		// 빈 3개를 생성하여 main에서 확인 (필요한 경우 코드 추가)
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Score hong = (Score)factory.getBean("hong");
		Score kim = (Score)factory.getBean("kim");
		Score choi = (Score)factory.getBean("choi");
		Score park = (Score)factory.getBean("park");
		
		System.out.println(hong.toString());
		System.out.println(kim.toString());
		System.out.println(choi.toString());
		System.out.println(park.toString());
	}
}
