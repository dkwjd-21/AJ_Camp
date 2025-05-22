package com.poly.part00_test.test05;

public class LG_TV implements Tv{

	private int vol;
	
	public LG_TV() {
		System.out.println("LG TV가 켜졌습니다.");
	}
	public LG_TV(int vol) {
		this.vol = vol;
		System.out.println("LG TV가 켜졌습니다.");
	}
	
	@Override
	public int volUp() {
		vol += 1;
		return vol;
	}

	@Override
	public int volDown() {
		vol -= 1;
		return vol;
	}
	
	public void tvCloser() {
		System.out.println("LG TV가 꺼졌습니다.");
	}

}
