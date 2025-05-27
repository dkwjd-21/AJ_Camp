package com.collection.part01_list.arrayList;

import java.util.*;

public class TestArrayList {
	public void test() {
		int[] arr = new int[3];
		
		ArrayList alist = new ArrayList();
		
		// 다형성
		List<Integer> list = new ArrayList<Integer>();		// 타입 고정 - integer
		Collection clist = new ArrayList();
		
		// arrayList : 저장 순서 유지, 중복 가능
		
		// 추가 add
		// arrayList는 객체만 저장 가능
		alist.add("apple");
		alist.add(123);			// autoBoxing 처리
		alist.add(45.67);
		alist.add(new Date());
		
		System.out.println("alist: "+alist);
		
		// index로 접근
		for(int i=0; i<alist.size(); i++) {
			System.out.println(i + " : " + alist.get(i));
		}
		
		// 배열의 크기 : length
		// 리스트의 크기 : size()
		
		// ArrayList는 중복 저장 허용
		alist.add("apple");
		System.out.println("alist : "+alist);
		
		alist.add(new String("apple"));
		System.out.println("alist : "+alist);
		
		// 리스트 중간에 추가. 하나씩 뒤로 밀림 
		alist.add(1, "banana");
		System.out.println("alist : "+alist);
		
		// 삭제
		alist.remove(2);
		System.out.println("alist : "+alist);
		System.out.println(alist.get(2));
		
		// 수정
		alist.set(1, true);
		System.out.println("alist : "+alist);
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty());
		
		alist.clear();
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty());
		
	}
	
	public void testSort() {
		// 기본적으로 제공되는 sort() 메소드, 오름차순 정렬된다. 
		
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("banana");
		list.add("grape");
		
		System.out.println("list : "+list);
		
//		list.sort(null);
		Collections.sort(list);
		System.out.println("list : "+list);
		
		Iterator dIter = new LinkedList(list).descendingIterator();
		
		ArrayList descList = new ArrayList();
		
		while(dIter.hasNext()) {
			descList.add(dIter.next());
		}
		System.out.println("descList : "+descList);
	}
}
