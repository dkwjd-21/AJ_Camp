package com.network.chap02_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		
		System.out.println(addr);
		System.out.println("host name : "+addr.getHostName());
		System.out.println("localhost : "+addr.getHostAddress());
		
		InetAddress[] naver = 
				InetAddress.getAllByName("www.naver.com");
//		System.out.println(naver[0]);
		
		for(int i=0; i<naver.length; i++) {
			System.out.println(naver[i]);
		}
	}
}
