package com.model.view;

import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.dto.Product;

public class ProductView {
	private ProductController controller = new ProductController();
	private Scanner sc = new Scanner(System.in);
	
	public void menu() {
		int no = 0;
		
		while(true) {
			System.out.println("---------------");
			System.out.println("1. 전체출력");
			System.out.println("2. 선택출력");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("6. 종료");
			System.out.println("---------------");
			System.out.println("번호 입력 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				List<Product> resAll = controller.selectAll();
				
				if(resAll.size() != 0) {
					for(Product p : resAll) {
						System.out.println(p);
					}
				}else {
					System.out.println("등록된 제품이 없습니다.");
				}				
				break;
			case 2:
				System.out.println("제품 선택 조회");
				Product resOne = controller.selectOne(inputId());
				if(resOne != null) {
					System.out.println(resOne);					
				} else {
					System.out.println("[조회하신 제품이 없습니다]");
				}

				break;
			case 3:
				System.out.println("*** 제품 추가 ***");
//				Product inputP = insertProduct();
//				controller.insert(inputP);
				int resInsert = controller.insert(insertProduct());
				if(resInsert>0) {
					System.out.println("[Insert 성공]");
				}else {
					System.out.println("[Insert 실패]");
				}
				
				break;
			case 4:
				System.out.println("*** 제품 수정 ***");
				// update 후 "[Update 성공]" 출력
				int resUpdate = controller.update(updateProduct());
				if(resUpdate>0) {
					System.out.println("[Update 성공]");
				} else {
					System.out.println("[Update 실패]");
				}
				break;
			case 5:
				System.out.println("*** 제품 삭제 ***");
				// delete 후 "[Delete 성공]" 출력 
				int resDelete = controller.delete(inputId());
				if(resDelete >0) {
					System.out.println("[Delete 성공]");
				} else {
					System.out.println("[Delete 실패]");
				}
				
				break;
			case 6:
				System.out.println("\n[프로그램 종료]\n");
				return;
			}
		}
		
	}
	
	public String inputId() {
		System.out.print("*** 조회할 제품 ID 입력: ");
		String id = sc.next();
		return id;
	}
	
	public Product insertProduct() {
		System.out.println("추가할 제품 ID : ");
		String id = sc.next();
		
		System.out.println("추가할 제품 이름 : ");
		String name = sc.next();
		System.out.println("추가할 제품 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("추가할 제품 설명 : ");
		String des = sc.next();
		
		return new Product(id, name, price, des);
	}
	
	public Product updateProduct() {
		Product p = new Product();
		
		// 수정할 가격, 제품 id 입력받아 Product 객체에 저장해서 리턴
		System.out.println("수정할 제품 ID : ");
		String id = sc.next();
		
		System.out.println("수정할 제품 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		p.setPid(id);
		p.setPrice(price);
		return p;
	}
	
	// 삭제는 위에 작성된 inputId 이용하여 id 입력받아 사용 
	
}
