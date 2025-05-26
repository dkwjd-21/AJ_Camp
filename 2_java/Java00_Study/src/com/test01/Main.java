package com.test01;

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 색종이의 수
		int n = Integer.parseInt(br.readLine());
		
		// 100*100 도화지
		boolean[][] paper = new boolean[100][100];
		
		// 색종이의 수만큼 반복문으로 색종이의 왼쪽 아래 점 좌표 입력받음
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			// [x][y]~[x+10][y+10] 까지 true로 바꾸기 
			// x와 y는 도화지의 왼쪽&아랫쪽 변 사이의 거리이기 때문에 0부터 시작함
			// = 배열의 인덱스와 일치함 
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					paper[j][k] = true;
				}
			}
		}
		
		// true 개수 = 넓이
		int cnt = 0;
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper[i].length; j++) {
				if(paper[i][j] == true) {
					cnt++;
				}
			}
		}
		
		// 넓이 출력
		System.out.println(cnt);
	}
}
