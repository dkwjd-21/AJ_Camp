package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean fruit = (MessageBean)factory.getBean("fruit");
		fruit.sayHello();
		
		fruit = (MessageBean)factory.getBean("apple");
		fruit.sayHello();
		
		// id가 mango인 bean을 가지고 와서 sayHello() 출력
		// 단, mango bean은 매개변수3개인 생성자 이용하여 빈 생성!
		// 매개변수 값은 알아서 .. 
		fruit = (MessageBean)factory.getBean("mango");
		fruit.sayHello();
	}
}
