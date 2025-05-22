package com.poly.part00_test.test05;

public class Samsung_TV implements Tv{
	
	private int vol;

	public Samsung_TV() {
		System.out.println("Samsung TV가 켜졌습니다.");
	}
	public Samsung_TV(int vol) {
		this.vol = vol;
		System.out.println("Samsung TV가 켜졌습니다.");
	}
	
	@Override
	public int volUp() {
		vol += 3;
		return vol;
	}

	@Override
	public int volDown() {
		vol -= 3;
		return vol;
	}
	
	public void tvCloser() {
		System.out.println("TV가 꺼졌습니다.");
	}
}
