package com.poly.part00_test.test05;

public class Run {
	public static void main(String[] args) {
		LG_TV lg = new LG_TV(3);
		System.out.println(lg.volUp());
		System.out.println(lg.volDown());		
		lg.tvCloser();
		
		Samsung_TV ss = new Samsung_TV(3);
		System.out.println(ss.volUp());
		System.out.println(ss.volDown());
		ss.tvCloser();
	}
}
