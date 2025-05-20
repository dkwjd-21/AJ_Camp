package com.silsub2.run;

import com.silsub2.model.Product;

public class Run {
	public static void main(String[] args) {
		Product p = new Product();
		
		p.setPName("아이폰");
		p.setPrice(1000000);
		p.setBrand("애플");
		
		System.out.println(p.information());
	}
}
