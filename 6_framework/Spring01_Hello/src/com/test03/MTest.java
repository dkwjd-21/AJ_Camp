package com.test03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class MTest {
	public static void main(String[] args) {
		
		// 호출 될 때 객체를 만듦 
		Resource res = new ClassPathResource("com/test03/beans.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		
//		ApplicationContext factory = 
//				new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		// 객체를 만들어놓고 사용함 
		MessageBean bean = (MessageBean)factory.getBean("korean");
		bean.sayHello("스프링");
		
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("Spring");
	}
}
