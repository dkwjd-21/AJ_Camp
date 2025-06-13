package com.controller;

import java.util.List;

import com.model.dto.Product;
import com.model.service.ProductService;

public class ProductController {
	private ProductService service = new ProductService();
	
	public List<Product> selectAll(){
		List<Product> res = service.selectAll();
		
		return res;
	}
	
	public Product selectOne(String id) {		
		return service.selectOne(id);
	}
	
	public int insert(Product dto) {
		return service.insert(dto);
	}
	
	public int update(Product dto) {
		return service.update(dto);
	}
	public int delete(String id) {
		return service.delete(id);
	}
}
