package com.poly.part00_test.test07;

// 여러 개의 인터페이스를 상속받기 위해서는 쉼표(,)로 구분한다
public class MyProfile extends Profile implements Display, Job{
	private String loc;

	public MyProfile(String name, String phone) {
		// 부모인 Profile 클래스에 기본 생성자 만들지 않음. 매개변수 호출해야함. 
		super(name, phone);
	}
	
	@Override
	public void jobLoc(String loc) {
		// TODO Auto-generated method stub
		this.loc = loc;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.printProfile();
		System.out.println("회사 주소: "+loc);
		System.out.println("회사 직종: "+jobId);
	}
	
	
}
