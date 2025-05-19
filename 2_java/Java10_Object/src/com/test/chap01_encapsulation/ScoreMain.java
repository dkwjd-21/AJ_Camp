package com.test.chap01_encapsulation;

public class ScoreMain {

	public static void main(String[] args) {
		// 1. Score 클래스로 객체 하나 생성
		Score score = new Score();
		// 2. 현재 저장된 점수들을 확인
		score.checkScore();
		// 3. 총합을 확인
		score.sumScore();
		// 4. 평균을 확인
		score.evgScore();
		// 5. 등급을 확인
		score.grade();
	}

}
