package com.poly.part00_test.test06;

// abstract 선언하면 원하는 추상 메소드만 만들면 됨!! 
public abstract class AreaImpl implements Area{
	private String result;

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(Area.print + result);
	}

	public void setResult(String result) {
		this.result = result;
	}
}
