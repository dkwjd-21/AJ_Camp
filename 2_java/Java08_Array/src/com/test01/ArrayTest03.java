package com.test01;

public class ArrayTest03 {
	
	public void prn(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void shallowCopy()
	{
		// 얕은 복사
		// 주소만 복사해서 가지고 온다. 
		int[] oArr = {1, 2, 3, 4, 5};
		int[] cArr = oArr;
		
		System.out.println("1. oArr");
		prn(oArr);
		System.out.println("2. cArr");
		prn(cArr);
		
		// 원본 배열에 값 변경
		oArr[0] = 99;
				
		System.out.println("oArr 변경 후");
		System.out.println("oArr");
		prn(oArr);
		System.out.println("cArr");
		prn(cArr);
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
	}
	
	public void deepCopy1()
	{
		// 깊은 복사 : 동일한 새로운 배열 하나 생성하고 값만 복사해 오는 것
		int[] oArr = {1, 2, 3, 4, 5};
		int[] cArr = new int[5];
		
		for(int i=0;i<oArr.length;i++)
		{
			cArr[i] = oArr[i];
		}
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);
		
		// 원본 배열에 값 변경
		oArr[0] = 99;
						
		System.out.println("oArr 변경 후");
		System.out.println("oArr");
		prn(oArr);
		System.out.println("cArr");
		prn(cArr);	
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
	}
	
	public void deepCopy2()
	{
		// arraycopy()
		// System에 있는 arraycopy() 활용 
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[10];
		
		// arraycopy(src, srcPos, de, dePos, length)
		/* src : 원본배열
		 * srcPos : 복사시작 위치
		 * de : 카피 배열
		 * dePos : 붙여넣기 시작 위치
		 * length : 복사될 길이
		 * */
		System.arraycopy(oArr, 1, cArr, 3, 3);
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
	}
	
	public void deepCopy3()
	{
		// clone() 이용한 복사
		int[] oArr = {1, 2, 3, 4, 5};
		int[] cArr = new int[10];
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
		
		cArr = oArr.clone();
		
		System.out.println("[oArr]");
		prn(oArr);
		System.out.println("[cArr]");
		prn(cArr);
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
	}
}
