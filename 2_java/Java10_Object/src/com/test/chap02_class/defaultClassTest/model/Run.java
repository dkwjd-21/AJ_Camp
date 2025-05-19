package com.test.chap02_class.defaultClassTest.model;

// * : 패키지 내의 모든 클래스 불러옴 
import com.test.chap02_class.defaultClassTest.model.*;

public class Run {

	public static void main(String[] args) {
		// 객체 생성
		// default 클래스는 패키지 외부에서 접근이 불가능
		// 같은 패키지에서 선언한 default 클래스는 접근 가능
		DefaultClassTest d = new DefaultClassTest();
		
		d.test();
	}

}
