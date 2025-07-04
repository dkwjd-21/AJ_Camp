package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Emp lee = factory.getBean("lee", Emp.class);
		Emp park = factory.getBean("park", Emp.class);
		
		System.out.println(lee);
		System.out.println(park);
	}
}
