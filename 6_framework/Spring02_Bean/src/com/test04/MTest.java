package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test04/ApplicationContext.xml");
		
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee.toString());
		
		Address kim = (Address)factory.getBean("kim");
		System.out.println(kim.toString());
		
		Member user1 = (Member)factory.getBean("user1");
		Member user2 = (Member)factory.getBean("user2");
		Member user3 = (Member)factory.getBean("user3");
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		System.out.println(user3.toString());
	}
}
