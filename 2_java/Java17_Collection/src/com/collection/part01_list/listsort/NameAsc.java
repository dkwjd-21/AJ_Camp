package com.collection.part01_list.listsort;

import java.util.Comparator;

public class NameAsc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String name1 = ((Score)o1).getName();
		String name2 = ((Score)o2).getName();
		
		return -name1.compareTo(name2);
	}
	
}
