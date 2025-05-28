package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.vo.Board;

public class DescBoardNo implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {
		// 내림차순. 오른쪽이 더 크면 바꿔줘야됨 
		// 바꾸려면 양수를 리턴 
		return -(o1.getBoardNo()-o2.getBoardNo());
	}

	

}
