package com.collection.part03_map.hashmap;

public class Score {
	private String name;
	private int point;
	
	public Score() {}
	public Score(String name, int point) {
		this.name = name;
		this.point = point;
	}
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
	
	@Override
	public String toString() {
		return "Score [name=" + name + ", point=" + point + "]";
	}
	
	
}
