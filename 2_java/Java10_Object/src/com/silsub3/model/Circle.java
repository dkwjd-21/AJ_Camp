package com.silsub3.model;

public class Circle {
	public static double PI = 3.14;
	private static int radius;
	
	public Circle() { }
	
	// PI
	public void setPI(double pi) {
		this.PI = pi;
	}
	public double getPI() {
		return PI;
	}
	// radius
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	
	// incrementRadius()
	public void incrementRadius() {
		this.radius++;
	}
}
