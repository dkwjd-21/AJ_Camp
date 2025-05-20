package com.silsub1.model;

import java.util.Scanner;

public class Sample {
	public void munjae1()
	{
		int[][] arr = new int[4][4];
		
		// 값 저장
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=0;j<arr[i].length-1;j++)
			{
				arr[i][j] = (int)(Math.random()*100)+1;
			}
		}
		
		// 합계 
		for(int i=0;i<arr.length-1;i++) 
		{
			for(int j=0;j<arr[i].length-1;j++)
			{
				arr[i][3] += arr[i][j];
				arr[3][i] += arr[j][i];
			}
			arr[3][3] += arr[i][3];
			arr[3][3] += arr[3][i];
		}
		
//		arr[3][3] = arr[0][3]+arr[1][3]+arr[2][3]
//				   +arr[3][0]+arr[3][1]+arr[3][2];
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr.length; j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	

	public void munjae2() {
		int[][] arr = new int[3][];
		Scanner sc = new Scanner(System.in);
		
		int[] sum = new int[arr.length];
		
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(i+"번째 1차원 배열 크기 : ");
			arr[i] = new int[sc.nextInt()];
			
			for(int j =0; i<arr[i].length; j++)
			{
				arr[i][j] = (int)(Math.random()*100)+1;
				sum[i] += arr[i][j];
			}
		}
		
		// 출력
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr.length; j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
