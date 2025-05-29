package com.thread.test01;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Thread01 th1 = new Thread01("성우");
		Thread01 th2 = new Thread01("유리");
//		th1.start();
//		th2.start();
		
		Thread01_1 th3 = new Thread01_1();
//		th3.run();
//		th1.run();
		
		// 우선순위 : 작업진행이 우선순위가 높은 스레드가 먼저 진행된다. (먼저 끝나는건X) 
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(8);
		
		th1.start();
		th2.start();
	}
}

class Thread01_1 extends Thread{
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		String str = sc.nextLine();
		
		System.out.println("str: "+str);
	}
}
