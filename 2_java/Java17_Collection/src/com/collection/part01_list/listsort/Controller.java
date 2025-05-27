package com.collection.part01_list.listsort;

import java.util.List;
import java.util.ArrayList;

public class Controller {
	public void test() {
		List list = new ArrayList();
		
		list.add(new Score("최유리", 99));
		list.add(new Score("김유리", 50));
		list.add(new Score("박유리", 70));
		list.add(new Score("송유리", 70));
		list.add(new Score("한유리", 70));
		list.add(new Score("백유리", 70));
		
		System.out.println("list: "+list);	
		
		// 1. Comparable - 기본 정렬 기준 구현
		// 해당 클래스(객체 생성 클래스, Score)에 구현
		
		// 2. Comparator - 기본 정렬 기준 이외 다른 정렬 기준 구현
		// 새로운 클래스에 구현 
		list.sort(null);
		System.out.println("list: "+list);
		
		list.sort(new PointAsc());
		System.out.println("list: "+list);
		
		// 이름 내림차순, 점수 내림차순 정렬을 할 수 있게 클래스 생성하고 그 기준에 맞게 완성해보자.
		list.sort(new NameDesc());
		System.out.println("list: "+list);
		
		list.sort(new PointDesc());
		System.out.println("list: "+list);
	}
}
