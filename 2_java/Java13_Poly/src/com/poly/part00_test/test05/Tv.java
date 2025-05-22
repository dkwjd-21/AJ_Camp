package com.poly.part00_test.test05;

public interface Tv {
	int volUp();
	int volDown();
	
	// lg tv 클래스와 samsung tv 클래스에서 해당 인터페이스 상속 후
	// lg tv volUp() 실행하면 +1, samsung tv volUp() 실행하면 +3
	// volUp() 완성
	// 반대로 -1, -3 해주는 volDown() 완성
	// 생성자 호출시 "tv가 켜졌습니다" 출력 
	// tvCloser() 만들어 호출하면 "tv가 꺼졌습니다." 출력
	
}
