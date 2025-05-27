package com.collection.part01_list.listsort;

import java.util.Comparator;

public class PointDesc implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		int point1 = ((Score)o1).getPoint();
		int point2 = ((Score)o2).getPoint();
		
		return point2-point1;
	}

}
