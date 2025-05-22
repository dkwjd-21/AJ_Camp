package com.poly.part00_test.test01;

public class MTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.bark();
		dog.eat("뼈다귀");
		
		Cat cat = new Cat();
		cat.bark();
		cat.eat("생선");
		
		// 추상클래스이기 때문에 객체화 할 수 없다. 
//		Animal a = new Animal();
		// 단, 자식 클래스 객체는 저장할 수 있다. => 다형성 
		Animal a = new Dog();
		Animal b = new Cat();
		a.bark();
		b.bark();
		
	}
}
