package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		Developer lee = factory.getBean("leecj", Developer.class);
		Engineer kim = factory.getBean("kimcj", Engineer.class);
		
		System.out.println(lee);
		System.out.println(kim);
	}
}
