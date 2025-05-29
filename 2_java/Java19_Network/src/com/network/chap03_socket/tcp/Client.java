package com.network.chap03_socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {	
	public static void main(String[] args) {
		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;		// 키보드로 입력 
		
		try {
			clientSocket = new Socket("localhost", 8888);
			System.out.println("server에 접속합니다.");
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine = null;
			while((inputLine = stdIn.readLine()) != null) {
				out.println(inputLine);
				System.out.println("server로부터 다시 받은 메시지 : "+in.readLine());
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				stdIn.close();
				in.close();
				out.close();
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
