package com.silsub4.model;

public class Student {
	private static int grade;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	{
		grade = 3;
		classroom = 4;
		name = "아정";
		height = 160.0;
		gender = 'F';				
	}	
	
	public Student() { }	
	
	// grade
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGrade() {
		return grade;
	}
	// classroom
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public int getClssroom() {
		return classroom;
	}
	// name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	// height
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	// gender
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
	
	// information
	public String information() {
		return "학년: "+grade+" 반: "+classroom
				+"\n이름: "+name+"\n키: "+height+"\n성별: "+gender;
	}
}
