package com.test03;

public class Developer extends Emp{
	private String dept;
	
	public Developer() {}

	public Developer(String name, int salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " \t 부서: "+ this.dept;
	}
	
	
}
