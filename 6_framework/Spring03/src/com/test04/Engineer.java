package com.test04;

public class Engineer {
	private Emp emp;
	private String dept;
	
	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString()+" \t 부서: "+dept;
	}
	
	
}
