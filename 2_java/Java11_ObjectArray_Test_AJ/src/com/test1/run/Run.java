package com.test1.run;

import com.test1.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		// 3개의 생성자를 사용하여 3명의 사원정보를 배열로 생성 
		Employee[] ep = new Employee[3];
		
		ep[0] = new Employee();
		ep[1] = new Employee(1, "홍길동", 19,'M', "010-2222-3333", "서울 잠실");
		ep[2] = new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, 
							 "010-1111-2222", "서울 잠실");
		
		// info 출력
		System.out.println(ep[0].information());
		System.out.println(ep[1].information());
		System.out.println(ep[2].information());
		System.out.println("=================================================");
		
		ep[0].setEmpNo(0);
		ep[0].setEmpName("김말똥");
		ep[0].setDept("영업부");
		ep[0].setJob("팀장");
		ep[0].setAge(30);
		ep[0].setGender('M');
		ep[0].setSalary(3000000);
		ep[0].setBonusPoint(0.2);
		ep[0].setPhone("010-5555-9999");
		ep[0].setAddress("전라도 광주");
		
		ep[1].setDept("기획부");
		ep[1].setJob("부장");
		ep[1].setSalary(4000000);
		ep[1].setBonusPoint(0.3);
		
		// info 출력
		System.out.println(ep[0].information());
		System.out.println(ep[1].information());
		System.out.println("=================================================");
		
		// 보너스가 적용된 연봉 계산하여 출력
		double sumSalary = 0;
		for(Employee emp : ep) {
			// 연봉 = (급여 + (급여*보너스포인트))*12
			double yearSalary = (emp.getSalary()+(emp.getSalary()*emp.getBonusPoint()))*12;
			sumSalary += yearSalary;
			System.out.println(emp.getEmpName()+"의 연봉 : "+(int)yearSalary+"원");			
		}
		System.out.println("=================================================");
		System.out.println("직원들의 연봉의 평균 : "+(int)sumSalary/ep.length+"원");
	}
}
