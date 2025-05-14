package com.test01;

public class MethodTest02 {

	public static void main(String[] args) {
		// 메소드 호출
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		// MethodTest01.privateMethod();	// 접근 안됨 not visible
		
		// nonStaticMethod : 변수 생성 없이 실행
		// 준비과정과 실행을 한번에... 
		new MethodTest01().NonStaticMethod();
	}

}
