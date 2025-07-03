package com.test03;

public class MessageBeanKo implements MessageBean{

	public MessageBeanKo() {
		System.out.println("ko 생성!");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("안녕하세요, "+name);
	}

}
