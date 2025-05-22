package com.poly.part00_test.test04;

public class MTest {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.bark();
		cat.eat("참치");
		
		Dog dog = new Dog();
		dog.bark();
		dog.eat("뼈다귀");
		dog.bite();
		
		Pigeon p = new Pigeon();
		p.bark();
		p.eat("벌레");
		p.fly();
		
		Animal a = new Cat();
		a = new Dog();
		a = new Pigeon();
		
		// 불가능!!!
//		Bird b = new Pigeon();
		
//		a.fly();	// a변수 타입이 Animal, Animal에는 fly() 없음!
		
	}
	
}
