package com.collection.part03_map.hashmap;

import java.io.*;
import java.util.*;

public class PropertiesTest {
	public void test() {
		// properties 
		// key, value 모두 String 객체
		Properties prop = new Properties();
		prop.setProperty("key", "value");
		prop.setProperty("id", "admin");
		prop.setProperty("pw", "1234");
//		prop.setProperty("age",12);
//		prop.put("pw", 12);				// 프로퍼티로써 사용했다 보기 어려움 
		
		System.out.println(prop);
		System.out.println();
		
		String id = prop.getProperty("id");
		String pw = prop.getProperty("pw");
//		int getPw = (int)prop.get("pw");
		System.out.println(id+", "+pw);
//		System.out.println("getPw: "+getPw);
		
		// 외부 파일로 출력 가능
		try {
			prop.store(new FileOutputStream("driver.properties"), "properties Test");
			prop.store(new FileWriter("driver.txt"), "properties Test");
			prop.storeToXML(new FileOutputStream("driver.xml"), "properties Test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test2() {
		// 파일로부터 읽기
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("driver.properties"));
			
			System.out.println(prop);
			System.out.println(prop.getProperty("name"));
			System.out.println(prop.getProperty("age"));
			System.out.println(prop.getProperty("id"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
