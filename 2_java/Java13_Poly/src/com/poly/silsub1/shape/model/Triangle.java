package com.poly.silsub1.shape.model;

import com.poly.silsub1.shape.controller.IShape;

public class Triangle implements IShape{
	private double base;
	private double height;
	
	public Triangle() {}
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double area() {
		return base*height/2;
	}
	@Override
	public double perimeter() {
		// 직각삼각형 빗변 
		double hypo = Math.sqrt(height*height+base*base);
		return base+height+hypo;
	}
	
	
	
}
