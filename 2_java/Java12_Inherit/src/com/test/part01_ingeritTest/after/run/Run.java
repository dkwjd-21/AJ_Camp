package com.test.part01_ingeritTest.after.run;

import java.util.Date;

import com.test.part01_ingeritTest.after.model.Desktop;
import com.test.part01_ingeritTest.after.model.SmartPhone;
import com.test.part01_ingeritTest.after.model.Television;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*public Television(String brand, String productNumber, 
		 * String productCode, String productName, int price, Date date,
			int inchType) {
		 *  
		 * */
		// "LG", "01", "T-01234", "LGTV", 2000000, new Date(), 65
		Television tv = 
				new Television("LG", "01", "T-01234", "LGTV", 2000000, new Date(), 65);
		System.out.println(tv.toString());
		
		/*public Desktop(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, boolean allInOne) {
		 * */
		
		Desktop dt = 
				new Desktop("apple", "02", "A-111", "Mac", 5000000, new Date(), "A-6", 500, 24, "MacOS", true);
		System.out.println(dt.toString());
		
		SmartPhone s = 
				new SmartPhone("samsung", "03", "G-1234", "갤럭시", 1500000, 
						new Date(), "퀼컴", 512, 36, "adnroid", "KT");
		System.out.println(s.toString());
		
		
		System.out.println(s.getBrand());
	}

}
