package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		// spring bean config 파일에서 작성된
		// Board클래스 bean을 3개 생성하여 main에서 확인
		// 객체의 필드 값들은 자유롭게 작성해 생성해봅시다. 
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test05/beans.xml");
		
		Board board1 = factory.getBean("board1", Board.class);
		Board board2 = factory.getBean("board2", Board.class);
		Board board3 = factory.getBean("board3", Board.class);
		
		System.out.println(board1);
		System.out.println(board2);
		System.out.println(board3);
	}
}
