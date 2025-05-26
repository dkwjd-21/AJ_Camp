package com.part00_file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// file 클래스
		// 경로에 작성된 파일이 없어도 File 객체 생성 가능
		// new File("경로"); ex 경로 : "C:\work\test\fileTest.txt"
		File file = new File("fileTest.txt");
		
		System.out.println("파일명 : "+file.getName());
		System.out.println("경로 : "+file.getAbsolutePath());
		System.out.println("파일크기 : "+file.length());
		
		// 파일이 없는 경우 생성
		// createNewFile() => 생성을 하면 true 리턴, 기존 파일이 존재하면 false 리턴
		try {
			boolean b = file.createNewFile();
			
			System.out.println("파일 생성 결과: "+b);
			System.out.println("파일 생성 완료!!");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("프로그램 종료");
		}
		
		// 필요 디렉토리 생성
		// -> 파일 생성 
//		File dir1 = new File("test");
//		dir1.mkdir();
//		
//		File dir2 = new File("test1/test2/test3");
//		dir2.mkdirs();
	}
}
