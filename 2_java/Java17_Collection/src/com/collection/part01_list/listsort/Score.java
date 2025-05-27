package com.collection.part01_list.listsort;

public class Score implements Comparable<Score>{
	private String name;
	private int point;
	
	// 생성자 
	public Score() {}
	public Score(String name, int point) {
		this.name = name;
		this.point = point;
	}
	
	// get set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	// toString
	@Override
	public String toString() {
		return "[name=" + name + ", point=" + point + "]";
	}
	
	@Override
	public int compareTo(Score o) {
		
		String otherName = o.getName();
		
		return name.compareTo(otherName);
		/*System.out.println("최유리".compareTo("김유리"));	// 양수. 자리 바꿈
		  System.out.println("김유리".compareTo("최유리")); // 음수. 자리 안바꿈
		  System.out.println("최유리".compareTo("최유리")); // 0. 제자리
		  
		  String의 기본정렬기준인 오름차순을 그대로 따라서
		  name 오름차순 정렬한다. 
		  
		  "나".compareTo("가") --> 양수
		  바꿀거라면 양수 그대로 리턴!!
		  안바꿀거라면 음수로 리턴!!!!!
		 * */
	}
}
