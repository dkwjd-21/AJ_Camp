package com.my.dto;

public class MyBoard {
	public static void main(String[] args) {
		int x=0;
		int y=10;

		do {
			y--;
			++x;
		} while (x < 5);

		System.out.print(x + "," + y);
	}
}
