package com.collection.part03_map.hashmap;

import java.util.*;

public class HashMapTest {
	public void test() {
		// HashMap Test
		HashMap hmap = new HashMap();
		
		// put(), key, value
		hmap.put("one", new Date());
		hmap.put(12, "red apple");		// 12 -> Integer 객체
		hmap.put(34, 123);
		// key, value 모두 반드시 객체여야 한다. 
		
		System.out.println("hmap : "+hmap);
		
		// 키는 중복 허용X
		hmap.put(12, "yellow banana");
		System.out.println("hmap : "+hmap);
		// value는 중복 허용 
		hmap.put(11, "yellow banana");
		hmap.put(19, "yellow banana");
		System.out.println("hmap : "+hmap);
		
		// value 가져오기
		System.out.println(hmap.get(19));
		
		// 삭제하기
		hmap.remove(19);		// 키와 value 같이 삭제됨
		System.out.println(hmap);
		
		// 갯수확인
		System.out.println("hmap에 저장된 객체 수 : "+hmap.size());
	}
	
	public void test2() {
		// map에 저장된 객체 연속 처리
		
		HashMap map = new HashMap();
		
		map.put("one", "비타500");
		map.put("two", "더벤티");
		map.put("three", "핸드크림");
		map.put("four", "에어팟");
		map.put("five", "칫솔");
		
		// 1. KeySet() - key만 set으로 만든다 
		Set keys = map.keySet();
		Iterator keyIt = keys.iterator();
		while(keyIt.hasNext()) {
			String key = (String)keyIt.next();
			String val = (String)map.get(key);
			System.out.println(key + "="+ val);
		}
		
		// 2. entrySet() - Map의 내부 클래스 Map.Entry를 set으로 만든다.
		Set set = map.entrySet();
		Iterator entryIt = set.iterator();
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIt.next();		// entry를 가지고 온다.
			System.out.println(entry.getKey()+"="+entry.getValue());
			
			// System.out.println(entry.getKey()+"="+entry.getValue());
			String key = (String)entry.getKey();
			String val = (String)entry.getValue();
			System.out.println(key+"="+val);
		}
		
		// 3. values() - 저장된 value 값들만 Collection으로 만든다.
		Collection values = map.values();
		Object[] arr = values.toArray();
		for(int i=0; i<arr.length; i++) {
			String val = (String)arr[i];
			System.out.println(val);
		}
	}
	
	public void test3() {
		// Score 클래스 객체 생성하며 map에 저장
		HashMap map = new HashMap();
		
		map.put("1", new Score("최유리", 100));
		map.put("2", new Score("김유리", 50));
		map.put("3", new Score("백유리", 80));
		
		System.out.println(map);
		
		map.clear();	// 초기화
		map.put(new Score(), "one");
		map.put(new Score("최유리", 100), "two");
		map.put(new Score("김유리", 50), "three");
		map.put(new Score("백유리", 80), "four");
		System.out.println(map);
		
		// 
		map.put(new Score("최유리", 100), "one");
		System.out.println(map);
	}
	
}
