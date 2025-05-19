package com.test01;

public class DeArrayTest01 {
	public void test1()
	{
		// 선언 == 변수 == stack
		int[][] iarr1;
		int iarr2[][];
		
		// 할당
		// new == heap
		iarr1 = new int[3][5];
		
		// 배열을 저장하는 배열은 반드시 크기를 지정하여 할당
		iarr2 = new int[3][];		
		System.out.print(iarr2[0]);		// null 출력
		System.out.println();
		
		// 정변 2차원 배열 
		iarr2[0] = new int[5];
		iarr2[1] = new int[5];
		iarr2[2] = new int[5];
		
		for(int i=0;i<iarr1.length;i++)
		{
			for(int j=0;j<iarr1[i].length;j++)
			{
				System.out.print(iarr1[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void test2()
	{
		// 2차원 배열에 값 기록
		int[][] iarr = new int[3][5];
		
		// 배열 인덱스별로 직접 작성하여 접근해 값 저장
		iarr[0][0] = 1;
		iarr[0][1] = 2;
		iarr[0][2] = 3;
		iarr[0][3] = 4;
		iarr[0][4] = 5;
		
		// 이중 for문을 이용하여 값 저장 
		int val = 1;
		for(int i=0;i<iarr.length;i++)
		{
			for(int j=0;j<iarr[i].length;j++)
			{
				iarr[i][j] = val++;
			}
		}
		
		// 이중 for문을 이용하여 저장된 값 출력 
		for(int i=0;i<iarr.length;i++)
		{
			for(int j=0;j<iarr[i].length;j++)
			{
				System.out.print(iarr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		// 가변배열
		iarr[0] = new int[5];
		iarr[1] = new int[3];
		iarr[2] = new int[10];
		
		val = 0;
		for(int i=0;i<iarr.length;i++)
		{
			for(int j=0; j<iarr[i].length; j++)
			{
				iarr[i][j] = ++val;
			}
		}
		
		for(int i=0;i<iarr.length;i++)
		{
			for(int j=0;j<iarr[i].length;j++)
			{
				System.out.print(iarr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void test3()
	{
		// 선언 및 할당과 동시에 초기화
		int[][] iarr = {{1,2,3}, {4,5,6,7}, {8,9,10,11,12}};
	
		for(int i=0;i<iarr.length;i++)
		{
			for(int j=0;j<iarr[i].length;j++)
			{
				System.out.print(iarr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void test4()
	{
		// 구구단을 2차원 배열에 넣기 
		int[][]	arr = new int[8][9];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j] = (i+2)*(j+1);
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
