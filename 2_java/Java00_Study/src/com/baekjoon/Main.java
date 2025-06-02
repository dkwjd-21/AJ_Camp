package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		
		System.out.println(Calculator.plus(5, 10));	// 15
	}
}

class Calculator{
	String color;
	void setColor(String color) {this.color = color;}
	static int plus(int x, int y) { return x+y; }
	static int minus(int x, int y) { return x-y; }
}
