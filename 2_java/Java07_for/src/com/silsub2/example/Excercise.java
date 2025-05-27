package com.silsub2.example;

import java.util.Scanner;

public class Excercise {
	public static void main(String[] args) {
//		new Excercise().excercise1();
		new Excercise().excercise2();
	}
	
	public void excercise1() {
		/* 1 2 3 4 5
		 * 6 7 8 9 10
		 * 11 12 13 14 15
		 * 16 17 18 19 20
		 * 21 22 23 24 25
		 * 
		 * 두 대각선 X의 합을 구하라
		 * */
		
		int[][] arr = new int[5][5];
		int cnt = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = cnt;
				cnt++;
			}
		}
		
		int sum = 0;
		// 첫번째 대각선 
		for(int i=0; i<5; i++) {
			for(int j=i; j<=i; j++) {
//				System.out.print(arr[i][j]+" ");
				sum += arr[i][j];
			}
		}
//		System.out.println();
		// 두번째 대각선 
		for(int i=0; i<5; i++) {
			for(int j=arr[i].length-1-i; j>=arr[i].length-1-i; j--) {
//				System.out.print(arr[i][j]+" ");
				sum += arr[i][j];
			}
		}
		
		System.out.println("중복 포함 : "+sum);
		System.out.println("중복 미포함 : "+(sum-13));		
	}

	public void excercise2() {
		/* 숫자 맞추기
		 * 1~100 난수 발생 시킨뒤 그 숫자를 맞추자
		 * 입력한 숫자가 난수보다 작으면 "입력하신 정수보다 작습니다"
		 * 입력한 숫자가 난수보다 크면 "입력하신 정수보다 큽니다"
		 * 정답을 맞추게 되면 몇번만에 맞춘건지까지 출력
		 * "정답입니다. 5회 만에 정답을 맞추셨습니다." 
		 * */
		
		int ran = (int)(Math.random()*100)+1;
		int input = -1;
		int cnt = 0;
		
		System.out.println("=========숫자 맞추기=========");
		do {
			System.out.println("양의 정수 입력! : ");
			input = new Scanner(System.in).nextInt();
			if(ran>input) {
				System.out.println("입력하신 정수보다 큽니다.");
			}else if(ran<input) {
				System.out.println("입력하신 정수보다 작습니다.");
			}
			cnt++;
		}while(ran!=input);
		
		System.out.println("정답입니다. "+cnt+"회 만에 정답을 맞추셨습니다.");
		System.out.println("정답: "+ran);
	}
}
