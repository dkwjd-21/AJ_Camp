package com.test01;

public class MessageBeanImpl implements MessageBean{
	private String fruit;
	private int cost;
	
	@Override
	public void sayHello() {
		System.out.println("과일: "+fruit+" \t가격: "+cost);
	}

	public MessageBeanImpl() {
		System.out.println("기본 생성자");
		fruit = "banana";
		cost = 5000;
	}

	public MessageBeanImpl(String fruit, int cost) {
		super();
		System.out.println("매개변수생성자(fruit, cost)");
		this.fruit = fruit;
		this.cost = cost;
	}
	
	public MessageBeanImpl(String fruit, int cost, String name) {
		System.out.println("매개변수생성자(fruit, cost, name)");
		this.fruit = fruit+name;
		this.cost = cost;
	}
}
