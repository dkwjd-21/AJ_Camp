package com.silsub2.model;

public class Model {
	public static void main(String[] args) {
		new Model().test1();		
		System.out.println();		
		new Model().test2();
	}
	
	public void test1() {
		int[][] arr = new int[5][5];
		
		int cnt = 1;
		for(int i=0; i<arr.length; i++) {
			if(i%2 == 0){
				// 홀수번째 줄 
				for(int j=0; j<arr[i].length; j++) {
					arr[i][j] = cnt;
					cnt++;
				}
			}else {
				// 짝수번째 줄
				for(int j=arr[i].length-1; j>=0; j--) {
					arr[i][j] = cnt;
					cnt++;
				}
			}				
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void test2() {
		int[][] arr = new int[5][5];
		
		int cnt = 1;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[j][i] = cnt;
				cnt++;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
