package com.poly.silsub1.shape.model;

import com.poly.silsub1.shape.controller.IShape;

public class Rectangle implements IShape{
	private double width;
	private double height;
	
	public Rectangle() {}
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double area() {
		return width*height;
	}
	@Override
	public double perimeter() {
		return (width+height)*2;
	}
	
	
	
}
