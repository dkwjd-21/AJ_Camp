package com.silsub3.run;

import com.silsub3.model.Circle;

public class Run {
	public static void main(String[] args) {
		Circle c = new Circle();
		Circle c2 = new Circle();
		
		// 반지름이 5인 원 생성
		c.setRadius(5);
		// 원의 둘레와 넓이 값 출력
		System.out.println("반지름이 "+c.getRadius()+"인 원의 둘레: "+2*c.getRadius()*c.getPI());
		System.out.println("반지름이 "+c.getRadius()+"인 원의 넓이: "+c.getRadius()*c.getRadius()*c.getPI());
		
		// 원의 반지름 1 증가
		c.incrementRadius();
		System.out.println(c.getRadius());		// 6
		System.out.println(c2.getRadius());		// 6
		// 원의 둘레와 넓이 값 출력
		System.out.println("반지름이 "+c.getRadius()+"인 원의 둘레: "+2*c.getRadius()*c.getPI());
		System.out.println("반지름이 "+c.getRadius()+"인 원의 넓이: "+c.getRadius()*c.getRadius()*c.getPI());
	}
}
