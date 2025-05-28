package com.collection.part04_generics.controller;

import java.util.*;

public class GenericsTest {
	public void test() {
		// 다루려는 클래스 타입을 지정
		// 컬렉션이 다룰 클래스 타입을 제한하여 한가지 종류의 클래스타입 객체만 저장하게 하는 기능 
		// 클래스타입 객체만 저장하는 기능
		
		// 잘못된 타입을 사용하여 형변환 등의 작업을 할 가능성을 제거
		// 컬렉션에 다양한 종류의 객체가 저장된다. 
		// 사용할 때마다 형변환을 해야한다. -> 코드 복잡
		
		// <> 해당 기호를 이용하여 클래스 명시
		
		List list = new ArrayList();
		
		list.add(new String("String Object"));
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		System.out.println("저장된 객체 수 : "+list.size());
		System.out.println("list : "+list);
		
		// 저장된 객체를 꺼내 사용할 때
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			
			if(obj instanceof String) {
				System.out.println(((String)obj).equals("test"));
			}else if(obj instanceof Book) {
				((Book) obj).prnBook();
			}else if(obj instanceof Student) {
				((Student)obj).score();
			}else if(obj instanceof Car) {
				((Car)obj).printCar();
			}
		}
	}
	
	public void test2() {
		// 제너릭스 : 컬렉션에 저장되는 객체의 자료형 제한 
		
		// 해당 list에는 Book 클래스 객체만 저장하겠다!
		List<Book> list = new ArrayList<Book>();
		
//		list.add("test");		// 에러!!
		list.add(new Book());
		list.add(new Book());
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).prnBook();
		}
		
		// ======================================
		List list2 = new ArrayList();
		list2.add(new Book());
		list2.add(new Book());
		for(int i=0; i<list2.size(); i++) {
//			list2.get(i).prnBook();				// Object만 있어서 prn 안됨
			((Book)list2.get(i)).prnBook();		// 형변환이 필요함!! 			
		}
		
	}

	public void test3() {
		// Map에는 제너릭스 적용
		HashMap<String, Book> map = new HashMap<>();
		map.put("one", new Book("java"));
		map.put("one", new Book("JS"));
		map.put("one", new Book("HTML"));
		System.out.println(map);
		
		System.out.println("-------------------------------------------------");
		Set<Map.Entry<String, Book>> entry = map.entrySet();
		Iterator<Map.Entry<String, Book>> it = entry.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Book> en = it.next();
			String key = en.getKey();
			Book val = en.getValue();
			System.out.println(key+":"+val);
		}
		
		// keySet() 을 이용하여 value 확인
		// 제너릭스 사용! 
		Set<String> keys = map.keySet();
		Iterator<String> keyIt = keys.iterator(); 
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Book b = map.get(key);
			
			System.out.println(key + "="+b);
		}
	}
}

// 한 클래스 파일 안에 여러 내부 클래스 정의 가능
// 단, public 접근제한자 1개만 가능. GenericsTest < 얘만
class Book{
	private String title;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public void prnBook() {
		System.out.println("printBook() call ...");
	}
	@Override
	public String toString() {
		return "Book" + title;
	}	
}

class Student{
	public Student() {}
	public void score() {
		System.out.println("Score() call...");
	}
	@Override
	public String toString() {
		return "Student";
	}	
}

class Car{
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "Car";
	}	
}