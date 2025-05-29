package com.thread.test02;

public class Run {
	public static void main(String[] args) {
		Thread th1 = new Thread(new Heart());
		Thread th2 = new Thread(new Start());
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
