package com.io.silsub1.model.dao;

import java.io.*;

public class FileOTest {
	public void fileSave() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = null;
		String input = null;
		
		try {
			System.out.println("파일명을 입력하시오.");
			String fileName = br.readLine();
			
			bw = new BufferedWriter(new FileWriter(fileName));
			
			do{
				System.out.println("파일에 저장할 내용을 입력하시오.");
				input = br.readLine();
				bw.write(input+"\n");
			}while(!input.equals("exit"));
			
			System.out.println("파일에 성공적으로 저장되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void fileRead() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BufferedReader file = null;
		
		System.out.println("파일명을 입력해주세요.");
		
		try {
			String input = br.readLine();
			file = new BufferedReader(new FileReader(input));
			
			String tmp = null;
			while((tmp=file.readLine()) != null) {
				System.out.println(tmp);
			}					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
