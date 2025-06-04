package com.test4.view;

import java.util.Scanner;

import com.test4.controller.MemberController;
import com.test4.model.vo.Member;

public class MemberMenu {
	private MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		// 반복문을 이용하여 메인 메뉴를 반복적으로 실행 
		while(true) {
			System.out.println("========== 회원 관리 메뉴 ==========");
			System.out.println("전체 회원 수 : "+mc.getMemberCount());
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호를 입력하세요 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				// 신규 회원 등록
				insertMember();
				break;
			case 2:
				// 회원 정보 검색
				searchMember();
				break;
			case 3:
				// 회원 정보 수정
				updateMember();
				break;
			case 4:
				// 회원 정보 삭제
				deleteMember();
				break;
			case 5:
				// 회원 정보 출력
				printAllMember();
				break;
			case 6:
				// 회원 정보 정렬
				sortMember();
				break;
			case 9:
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}			
		}
	}
	
	public void insertMember() {
		// 1. 현재 회원 수(memberCount)가 최대 회원 수(SIZE)를 넘어설 경우 return 처리
		if(mc.getMemberCount() > mc.SIZE) {
			return;
		}
		
		// 2. 아이디를 입력받아 MemberController checkId() 메소드로 전달 >> 결과값
		System.out.println("사용할 아이디를 입력하세요 : ");
		String id = sc.nextLine();
		Member target = mc.checkId(id);
		
		if(target != null) {
			// 2-1. 결과값이 null이 아닌 경우. 동일한 아이디가 존재하는 경우
			System.out.println("동일한 아이디가 존재합니다.");
			System.out.println("회원등록 실패");
		}else {	
			// 2-2. 결과값이 null인 경우. 동일한 아이디가 존재하지 않는 경우
			// 나머지 회원 정보를 입력 받음
			System.out.println("사용할 비밀번호를 입력하세요 : ");
			String pw = sc.nextLine();
			System.out.println("이름을 입력하세요 : ");
			String name = sc.nextLine();
			System.out.println("나이를 입력하세요 : ");
			int age = sc.nextInt();	sc.nextLine();
			System.out.println("성별을 입력하세요(F/M) : ");
			char gender = sc.nextLine().toUpperCase().charAt(0);
			System.out.println("이메일을 입력하세요 : ");
			String mail = sc.nextLine();
			
			// 입력받은 정보를 Member의 매개변수 생성자를 이용하여 객체 생성 후
			Member newMem = new Member(id, pw, name, age, gender, mail);
			// mc의 insertMember() 메소드로 전달
			mc.insertMember(newMem);
			System.out.println("성공적으로 회원 등록이 되었습니다.");
		}		
	}

	public void searchMember() {
		while(true) {
			System.out.println("======= 회원 정보 검색 =======");
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt(); sc.nextLine();
			if(menu==9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}else {
				System.out.println("검색 내용 : ");
				String search = sc.nextLine();
				
				Member result = mc.searchMember(menu, search);
				
				if(result == null) {
					System.out.println("검색된 결과가 없습니다.");
					return;
				}else {
					System.out.println(result.information());
					return;
				}
			}							
		}
	}
	
	public void updateMember() {
		// 메뉴 출력 
		while(true) {
			System.out.println("======= 회원 정보 수정 =======");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt(); sc.nextLine();
			
			if(menu==9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}else {
				System.out.println("변경할 회원 아이디 : ");
				String userId = sc.nextLine();
				
				// checkId 
				Member m = mc.checkId(userId);
				if(m == null) {
					System.out.println("변경할 회원이 존재하지 않습니다.");
					return;
				}else {
					System.out.println(m.information());
					System.out.println("변경할 내용을 입력해주세요 : ");
					String update = sc.nextLine();
					
					mc.updateMember(m, menu, update);
					System.out.println("회원 정보가 변경되었습니다.");
					return;
				}		
			}						
		}
	}

	public void deleteMember() {
		System.out.println("삭제할 회원 아이디 : ");
		String userId = sc.nextLine();
		
		Member m = mc.checkId(userId);
		if(m==null) {
			System.out.println("삭제할 회원이 존재하지 않습니다.");
		}else {
			System.out.println("정말 삭제하시겠습니까? (y/n) : ");
			char res = sc.nextLine().toUpperCase().charAt(0);
			if(res == 'Y') {
				mc.deleteMember(userId);
				System.out.println("회원의 정보가 삭제되었습니다.");
			}else {
				System.out.println("삭제를 취소하였습니다.");
			}
		}
	}
	
	public void printAllMember() {
		// mc의 getMem() 호출 
		Member[] mem = mc.getMem();
		for(int i=0; i<mc.getMemberCount(); i++) {
			System.out.println(mem[i].information());
		}
	}
	
	public void sortMember() {
		System.out.println("====== 회원 정보 정렬 ======");
		System.out.println("1. 아이디 오름차순 정렬");
		System.out.println("2. 아이디 내림차순 정렬");
		System.out.println("3. 나이 오름차순 정렬");
		System.out.println("4. 나이 내림차순 정렬");
		System.out.println("5. 성별 내림차순 정렬 (남여 순)");
		System.out.println("9. 이전 메뉴로");
		System.out.println("메뉴 선택 : ");
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu == 9) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			return;
		}else {
			Member[] mem = null;
			switch(menu) {
			case 1:
				mem = mc.sortIdAsc();
				break;
			case 2:
				mem = mc.sortIdDesc();
				break;
			case 3:
				mem = mc.sortAgeAsc();
				break;
			case 4:
				mem = mc.sortAgeDesc();
				break;
			case 5: 
				mem = mc.sortGenderDesc();
				break;
			}			
			for(int i=0; i<mc.getMemberCount(); i++) {
				System.out.println(mem[i].information());
			}
			return;
		}
	}
}
