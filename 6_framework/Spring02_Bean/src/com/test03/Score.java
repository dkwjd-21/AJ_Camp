package com.test03;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {}

	public Score(String name) {
		super();
		this.name = name;
	}
	
	public Score(String name, int kor) {
		super();
		this.name = name;
		this.kor = kor;
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
}
