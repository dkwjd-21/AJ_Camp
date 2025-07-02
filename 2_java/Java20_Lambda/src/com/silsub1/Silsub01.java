package com.silsub1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Silsub01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		Trader raoul = new Trader("kim", "Seoul");
		Trader mario = new Trader("lee", "Suwon");
		Trader alan = new Trader("park", "Busan");
		Trader brain = new Trader("choi", "Incheon");
		
		List<Transaction> transactions = Arrays.asList(
	       new Transaction(brain, 2021, 500),
	       new Transaction(raoul, 2022, 1200),
	       new Transaction(raoul, 2021, 300),
	       new Transaction(mario, 2022, 620),
	       new Transaction(mario, 2022, 810),
	       new Transaction(alan, 2022, 990)
	   );
		
		while(true) {
			System.out.println("===== 메뉴 선택 =====");
			System.out.println("1. 2021년에 일어난 모든 트랙잭션을 value 기준으로 오름차순 정렬");
			System.out.println("2. 2022년에 일어난 모든 트랙잭션을 value 기준으로 오름차순 정렬");
			System.out.println("3. 거래자가 근무하는 모든 도시를 중복 없이 나열");
			System.out.println("4. 서울에서 근무하는 모든 거래자를 찾아 이름순으로 정렬");
			System.out.println("5. 모든 거래자의 이름을 알파벳 순으로 정렬");
			System.out.println("6. 인천에 거래자가 있는지 여부");
			System.out.println("7. 수원에 거주하는 거래자의 모든 트랜잭션 값 출력");
			System.out.println("8. 전체 트랙잭션 중 value 값의 최댓값 출력");
			System.out.println("9. 프로그램 종료");
			System.out.println("번호 선택 : ");
			
			int no = Integer.parseInt(br.readLine());
			
			switch(no) {
			case 1:
				// 1. 2021년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오.
				// List -> Stream 으로 변환
				transactions.stream()	
					.filter(t -> t.getYear() == 2021)
					// .sorted(Comparator.comparing(Transaction::getValue))
					.sorted((t1, t2) -> t1.getValue()-t2.getValue())
					.forEach(t -> System.out.println(t));
				break;
			case 2:
				// 2. 2022년에 일어난 모든 트랜잭션을 찾아 필드 value를 기준으로 오름차순으로 정렬하시오.
				transactions.stream()
					.filter(t -> t.getYear() == 2022)
					.sorted(Comparator.comparing(Transaction::getValue))
					.forEach(t -> System.out.println(t));;
				break;
			case 3:
		        // 3. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
				transactions.stream()
					// 모든 도시를 가져옴
					.map(t -> t.getTrader().getCity())	
					// 중복 제거
					.distinct()		
					// 출력
					.forEach(city -> System.out.print(city+" "));
				System.out.println();
				break;
			case 4:
				// 4. 서울에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
				transactions.stream()
					.filter(t -> t.getTrader().getCity().equals("Seoul"))
					.sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
					.forEach(t -> System.out.println(t));				
				break;
			case 5:
				// 5. 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오.
				transactions.stream()
					.sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
					.forEach(t -> System.out.println(t));
				break;
			case 6:
				// 6. 인천에 거래자가 있는가?
				boolean hasIncheonTrader = transactions.stream()
											.anyMatch(t -> t.getTrader().getCity().equals("Incheon"));
				
				if(hasIncheonTrader) {
					System.out.println("있습니다.");
					transactions.stream().filter(t -> t.getTrader().getCity().equals("Incheon"))
										 .forEach(t -> System.out.println(t));
				} else {
					System.out.println("없습니다.");
				}
				break;
			case 7:
				// 7. 수원에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
				transactions.stream()
					.filter(t -> t.getTrader().getCity().equals("Suwon"))
					.forEach(t -> System.out.println(t));
				break;
			case 8:
				// 8. 전체 트랜잭션 중 필드value의 값이 최댓값은 얼마인가?
				int max = transactions.stream()
							.max(Comparator.comparing(Transaction::getValue))
							.get().getValue();
				System.out.println("최댓값은 "+max+"입니다.");
				break;
			case 9:
				System.out.println("===== 프로그램을 종료합니다. =====");
				br.close();
				return;
			}
		}
	}
}
