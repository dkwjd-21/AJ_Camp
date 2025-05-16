package com.test01;

public class ArrayTest01 {
	public void testArray1()
	{
		// 배열 사용 이유
//		int num1 = 10;
//		int num2 = 20;
//		int num3 = 30;
//		int num4 = 40;
//		int num5 = 50;
//		
//		int sum = 0;
//		sum += num1;
//		sum += num2;
//		sum += num3;
//		sum += num4;
//		sum += num5;
//		
		int[] arr = new int[5];
//		arr[0] = 10;
//		arr[1] = 10;
//		arr[2] = 10;
//		arr[3] = 10;
//		arr[4] = 10;
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (i+1)*10;
		}
		
		int sum =0;
		
		for(int i=0; i<arr.length; i++)
		{
			sum += arr[i];
		}			
	}
	
	public void testArray2()
	{
		// 배열 사용 방법
		// 선언
		// 자료형[] 변수명;
		// 자료형 변수명[];
		// 선언은 stack에 배열의 주소를 보관할 수 있는 공간을 만드는 것
		
//		int[] iarr;
//		char carr[];
//		
//		// 할당
//		// new 타입[크기];
//		// new 연산자는 heap 영역에 공간을 할당하고 발생한 주소값을 반환하는 연산자
//		iarr = new int[3];
//		
//		int size = 5;
//		iarr = new int[size];
		
		
		// 선언과 할당
		int[] iarr = new int[5];
		char carr[] = new char[10];
		
		System.out.println("iarr: "+ iarr);
		System.out.println("carr: "+ carr);
		
		// hashCode : 주소값 
		System.out.println("iarr의 hashcode: "+ iarr.hashCode());
		System.out.println("carr의 hashcode: "+ carr.hashCode());
		
		int[] iarr2 = new int[3];
		System.out.println("iarr2의 hashcode: " + iarr2.hashCode());
		
		// length : 길이
		System.out.println("iarr의 길이: " + iarr.length);
		System.out.println("carr의 길이: " + carr.length);
		
		// 
		double[] darr = new double[10];
		System.out.println("darr의 길이: " + darr.length);
		System.out.println("darr의 hashCode: " + darr.hashCode());
		
		// 배열의 길이 변경 -> 배열의 길이는 한 번 생성 후에는 변경 불가 
		// darr.length = 30; 		// 못 바꾸지롱 
		
		// new double로 다시 할당하면 hashcode(주소)가 바뀐다. 
		darr = new double[30];		
		// 즉, 배열의 길이를 변경한 코드가 아닌, 새로운 배열을 할당한 코드이다. 
		System.out.println("new darr의 길이: " + darr.length);
		System.out.println("new darr의 hashCode: " + darr.hashCode());
		
		// 배열 삭제 
		// 직접 할당된 배열은 삭제 불가. 참조관계를 끊어 줌으로써 더이상 참조당하지 않는 공간은 GC가 삭제하게 된다.  
		// darr.remove / darr.delete 이런거 없음
		darr = null;
		// 참조 관계만 끊으면 알아서 메모리도 삭제됨. 메모리 관리가 편함
		
		// NullPointerException : 
		// System.out.println("삭제 후 darr의 길이: "+ darr.length);
	}
	
	public void testArray3()
	{
		// 정수값을 저장하는 크기가 5인 배열 
		int[] iarr = new int[5];
		
		// System.out.println(iarr[0]);
		
		for(int i=0; i<iarr.length; i++)
		{
			System.out.println(iarr[i]);
		}
		// 0 출력 
		// heap 영역은 값이 없는 공간이 존재할 수 없다. 
		// 배열을 선언하고 할당을 하면 지정된 값으로 초기화 진행 
		
		double[] darr = new double[5];
		System.out.println(darr[0]);
		char[] carr = new char[1];
		System.out.println(carr[0]);
		String[] sarr = new String[3];
		System.out.println(sarr[0]);
		
		// 퀴즈
		// 기본값 외의 값으로 채워 넣으면서 배열을 생성하고 싶다. 
		int[] iarr2 = {11,22,33,44,55};
		
		for(int i=0; i<iarr2.length; i++)
		{
			System.out.println("iarr2: "+iarr2[i]);
		}
		System.out.println(iarr2.length);
	}
	

	
}
