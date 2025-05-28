package com.test4.controller;

import com.test4.model.vo.Member;
import java.util.*;

public class MemberController {
	public static int SIZE = 10;				// 최대 회원 수
	private int memberCount;					// 현재 회원 수 
	private Member[] mem = new Member[SIZE];	// 회원 객체 배열
	
	// 초기화 블럭을 이용하여 기본적인 회원 5명의 정보 초기화, memberCount 수 초기화 
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@naver.com");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@naver.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;
	}	
	
	public int getMemberCount() {
		return memberCount;
	}
	public Member[] getMem() {
		return mem;
	}
	
	public Member checkId(String userId) {
		// 아이디로 검색된 결과를 담을 변수 초기화
		Member m = null;
		
		// 매개변수로 전달받은 userId와 동일한 아이디를 가지고 있는 회원을 m에 대입
		for(int i=0; i<memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				m = mem[i];
				break;
			}
		}
		
		return m;
	}
	
	public void insertMember(Member m) {
		// 매개변수로 전달받은 회원정보를 mem 객체에 추가
		mem[memberCount-1] = m;
		
		// memberCount 1 증가
		memberCount++;
	}
	
	public Member searchMember(int menu, String search) {
		// 검색된 회원 정보를 담을 수 있는 변수 초기화
		Member searchMember = null;
		
		// 매개변수로 전달받은 search 문자열을 menu 번호에 따라 ->
		switch(menu) {
		case 1:
			// 1인 경우 아이디로 검색 후 결과를 searchMember에 대입
			for(int i=0; i<memberCount; i++) {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
					break;
				}
			}
		case 2:
			// 2인 경우 이름으로 검색 후 결과를 searchMember에 대입
			for(int i=0; i<memberCount; i++) {
				if(mem[i].getName().equals(search)) {
					searchMember = mem[i];
					break;
				}
			}			
		case 3:
			// 3인 경우 이메일로 검색 후 결과를 searchMember에 대입
			for(int i=0; i<memberCount; i++) {
				if(mem[i].getEmail().equals(search)) {
					searchMember = mem[i];
					break;
				}
			}
		}
		
		return searchMember;
	}
	
	public void updateMember(Member m, int menu, String update) {
		// 매개변수로 전달받은 m 회원과 변경 내용인 update 문자열을 menu에 따라 -> 
		switch(menu) {
		case 1:
			// 1인 경우 setter 메소드를 이용하여 m의 비밀번호를 update 문자열로 변경
			m.setUserPwd(update);
			break;
		case 2:
			// 2인 경우 setter 메소드를 이용하여 m의 이름을 update 문자열로 변경
			m.setName(update);
			break;
		case 3:
			// 3인 경우 setter 메소드를 이용하여 m의 이메일을 update 문자열로 변경
			m.setEmail(update);
			break;			
		}
	}
	
	public void deleteMember(String userId) {
		// 매개변수로 전달받은 userId가 mem에 존재하는 경우 해당 회원 삭제 후 
		int idx = -1;	// 해당 회원의 인덱스
		for(int i=0; i<memberCount; i++) {
			if(mem[i].getUserId() == userId) {
				idx = i;
			}
		}
		
		// 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동시킴
		// 실행시 NullPointerException을 발생할 수 있음 
		if(idx>=0) {
			for(int i=idx; i<memberCount; i++) {
				Member tmp = mem[i+1];
				mem[i] = tmp;
			}
		}				
		
		// memberCount 1 감소 
		memberCount--;
	}
	
	public Member[] sortIdAsc() {
		// 기존의 회원 객체 배열을 변경하지 않고 단지 정렬된 결과만을 보여줌
		// 기존의 배열 복사해서 사용. clone() or System.arraycopy() 둘 중 하나 사용
		Member copy[] = mem.clone();
		
		// copy 배열을 아이디별 오름차순 정렬 진행 *compareTo() 메소드 활용
		
		
		return copy;		
	}
	
	public Member[] sortIdDesc() {
		Member copy[] = mem.clone();
		
		return copy;
	}
	
	public Member[] sortAgeAsc() {
		Member copy[] = mem.clone();
		
		return copy;
	}
	
	public Member[] sortAgeDesc() {
		Member copy[] = mem.clone();
		
		return copy;
	}
	
	public Member[] sortGenderDesc() {
		Member copy[] = mem.clone();
		
		return copy;
	}
}
