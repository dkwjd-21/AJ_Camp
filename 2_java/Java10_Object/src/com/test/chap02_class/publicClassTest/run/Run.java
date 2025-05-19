package com.test.chap02_class.publicClassTest.run;

import com.test.chap02_class.publicClassTest.model.PublicClassTest;

public class Run {

	public static void main(String[] args) {
		// 객체 생성
		// Test() 실행
		// 패키지가 다르기 때문에 import 하지 않으면 오류 발생
		PublicClassTest t = new PublicClassTest();
		t.test();
	}

}
