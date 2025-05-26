package com.part02_charStream.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
	public void filesave() {
		// 문자 단위의 기반스트림
		// FileWriter
		FileWriter fw = null;
		
		try {
			// 파일이 존재하지 않으면 자동 생성한다.
			fw = new FileWriter("sample2.txt");
			
			fw.write("안녕하세요 반가워요");
			fw.write('A');
			char[] carr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(carr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void fileopen() {
		// 문자 기반
		// FileReader
		FileReader fr = null;
		try {
			fr = new FileReader("sample2.txt");
//			System.out.print((char)fr.read());
//			System.out.print((char)fr.read());
			int val;
			
			while((val=fr.read()) != -1) {
				System.out.print((char)val);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// new 기반스트림("외부자원");
	// new 보조스트림(new 다른스트림()); 		// 다른스트림: 또 다른 보조스트림 or 기반스트림
	// new 보조스트림(new 보조스트림(new 다른스트림()));
	// new 보조스트림(new 기반스트림("외부자원"));
	
	
}
