package com.test02.view;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.test02.model.MyTestDao;
import com.test02.model.MyTestDto;

public class MyTestView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyTestDao dao = new MyTestDao();
		
		int mno = 0;
		String mname = null;
		String nickName = null;
		
		Connection con = getConnection();
		
		int no = 0;
		do {
			System.out.println("1. 전체 출력");
			System.out.println("2. 추가");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.println("----------------------------");
			System.out.println("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				// 전체출력 
				System.out.println("*** 전체 출력 ***");
				List<MyTestDto> res = dao.getAll(con);
				
				if(res.size()==0) {
					System.out.println("조회된 데이터가 없습니다.");
				}else {
					for(MyTestDto dto : res) {
						System.out.println(dto);
					}
				}
				break;
			case 2:
				System.out.println("*** 추가 ***");
				System.out.println("추가할 번호 : ");
				mno = sc.nextInt();
				sc.nextLine();
				System.out.println("추가할 이름 : ");
				mname = sc.nextLine();
				System.out.println("추가할 별명 : ");
				nickName = sc.nextLine();
				
				MyTestDto dto = new MyTestDto(mno, mname, nickName);
				int insertRes = dao.insert(con, dto);
				if(insertRes>0) {
					System.out.println("입력 성공!");
				}else {
					System.out.println("입력 실패ㅠㅠ");
				}
				break;				
			case 3: 
				// 데이터 수정 
				System.out.println("수정하려는 번호 : ");
				mno = sc.nextInt();
				sc.nextLine();
				System.out.println("수정할 이름 :");
				mname = sc.nextLine();
				System.out.println("수정할 별명 : ");
				nickName = sc.nextLine();
				MyTestDto update = new MyTestDto(mno, mname, nickName);
				
				int updateRes = dao.update(con, update);
				
				if(updateRes>0) {
					System.out.println("수정 성공!");
				}else {
					System.out.println("수정 실패 ㅠㅠ");
				}
				break;				
			case 4:
				// 데이터 삭제 
				System.out.println("*** 삭제 ***");
				System.out.println("삭제할 번호 : ");
				mno = sc.nextInt();
				
				if(dao.delete(con, mno)>0) {
					System.out.println("삭제 성공!");
				}else {
					System.out.println("삭제 실패 ㅠㅠ");
				}
				break;
			case 5:
				// 종료 
				System.out.println("[프로그램 종료]");
				close(con);
				sc.close();
				return;
			}
			
		}while(no!=5);
	}
}
