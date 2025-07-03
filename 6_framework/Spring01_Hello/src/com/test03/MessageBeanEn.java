package com.test03;

public class MessageBeanEn implements MessageBean{
	
	public MessageBeanEn() {
		System.out.println("en 생성!");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, "+name);
	}

}
