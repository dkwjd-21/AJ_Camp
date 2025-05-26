package com.part01_byteStream.model;

import java.io.*;

public class TestByteStream {
	public void filesave() {
		// byte 단위로 데이터를 출력할 수 있는 스트림
		// FileOutputStream
		
		// 대상 파일 (외부자원, sample.txt)가 존재하지 않아 자동으로 생성
		FileOutputStream fout = null;
		
		// 스트림 생성
		try {
			fout = new FileOutputStream("sample.txt");
			
			// 출력 작업
			fout.write(97);			// txt 파일에 저장됨 
			
			byte[] barr = {98, 99, 100, 101, 102, 10};
			fout.write(barr);
			fout.write(barr, 1, 3);
			
//			fout.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}			
		}
		
	}

	public void fileopen() {
		// 파일로부터 byte 단위로 데이터를 읽어 올 수 있는 스트림
		// FileInputStream
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("sample.txt");
			
//			int fileSize = (int)new File("sample.txt").length();
//			System.out.println(fileSize);
//			
//			// 파일의 크기 만큼의 배열 선언
//			byte[] barr = new byte[fileSize];
//			
//			fin.read(barr);
//			
//			for(int i=0; i<barr.length; i++) {
//				System.out.print(barr[i]+" ");
//			}
			
//			System.out.println(fin.read());
			
			int val = 0;
			
			while((val=fin.read()) != -1) {
				System.out.print((char)val+" ");
			}
			System.out.println();
			System.out.println("while 종료 후 val : "+val);
			
			// 한글은 2byte. 깨진다. 
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				fin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void filesave2() {
		// try with resource 문
		// try(객체 생성){} catch(예외클래스){}
		// 자동으로 close() 처리 -> IOExcpetion 예외 처리해라!!! 
		
		// FileOutputStream 객체 생성
		try(FileOutputStream fout = new FileOutputStream("sample.txt")){
			fout.write(65);
			byte[] b = {66, 67};
			fout.write(b);
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
	}
	
	public void fileopen2() {
		// fileopen()과 동일하게 sample.txt에서 데이터를 읽어와 출력하기
		// 단, try with resource 이용해서 구현 
		
		// alt + shift + z 단축키 : try, catch
		try(FileInputStream fin = new FileInputStream("sample.txt")){
			int size = (int)new File("sample.txt").length();
			byte[] b = new byte[size];
			
			fin.read(b);
			for(int i=0; i<b.length; i++) {
				System.out.print(b[i]+" ");
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			
		}
	}
}
