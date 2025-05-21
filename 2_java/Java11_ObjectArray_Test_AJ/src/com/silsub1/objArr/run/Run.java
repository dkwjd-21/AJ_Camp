package com.silsub1.objArr.run;

import com.silsub1.objArr.mode.vo.Student;

public class Run {
	public static void main(String[] args) {
		Student[] s = new Student[3];
		
		s[0] = new Student(3, 1, 1, "홍길동");
		s[1] = new Student(4, 3, 2, "유관순");
		s[2] = new Student(2, 7, 5, "윤봉길");
		
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i].information());
		}
	}
}
