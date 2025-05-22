package com.poly.silsub1.shape.model;

import com.poly.silsub1.shape.controller.IShape;

public class Circle implements IShape{
	private double radius;
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return radius*radius*Math.PI;
	}
	@Override
	public double perimeter() {
		return (radius*2)*Math.PI;
	}
	
	
}
