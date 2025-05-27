package com.collection.part02_set.hashset;

import java.util.*;

public class HashSetTest {
	public void test() {
		HashSet hset = new HashSet();		
//		Set hser2 = new HashSet();
		
		// 데이터 추가
		hset.add("Java");
		hset.add(123);			// wrapper 클래스로 객체화 되어 저장
		hset.add(45.67);
		hset.add(new Date());
		
		// 순서 유지 안된다!
		System.out.println("hset: "+hset);
		
		// 중복 허용하지 않는다! 
		hset.add("Java");
		hset.add(123);
		System.out.println("hset: "+hset);
		System.out.println("저장된 객체 수: "+hset.size());
		System.out.println("포함 확인: "+ hset.contains(123));
		
		// 저장된 객체에 하나씩 접근
		// Iterator() 메소드 : 저장된 객체를 목록으로 만들어 준다. 줄을 세운다. 
		Iterator it = hset.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("한번더!!!");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// toArray() 사용
		Object[] ar = hset.toArray();
		for(int i=0; i<ar.length; i++) {
			System.out.println(i + ": "+ar[i]);
		}
		
		// 삭제
		hset.remove(123);
		System.out.println(hset);
		hset.clear();
		System.out.println("비었나? : "+hset.isEmpty());
	}

	public void test2() {
		// 데이터 중복 저장
//		Set set = new HashSet();
		
		// Set<Member> set = new HashSet<Member>();
		// <> : 제네릭.
		Set<Member> set = new HashSet<Member>();
		// set.add(set) : 에러 발생. 지금 set에는 Member클래스 객체만 저장 가능
		
		set.add(new Member("최유리", 24, "010-1111-1111"));
		set.add(new Member("김유리", 22, "010-2222-2222"));
		set.add(new Member("백유리", 23, "010-3333-3333"));
		
		System.out.println(set);
		
		// 중복 허용 X!! -> new Member로 새 객체를 만들었기 때문에 추가가 되어버림
		set.add(new Member("최유리", 24, "010-1111-1111"));
		set.add(new Member("김유리", 22, "010-2222-2222"));
		
		System.out.println(set);
		
		// 클래스 객체에 hashcode, equals를 오버라이딩.
		
	}
}
