package com.chap05_date.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Run {
	/*
	 * Date
	 * Calendar
	 * GregorianCalender
	 * - java.util 패키지
	 * */
	
	public static void main(String[] args) {
		Date oriTime = new Date();						// 70년 1월 1일
		System.out.println(oriTime);
		oriTime = new Date(1000L);						// 최초 셋팅값에서 1초 흐른 시간
		System.out.println(oriTime);
		System.out.println(oriTime.toGMTString());		// 그리니치
		
		
		Date today = new Date();
		
		// 원하는 패턴으로 출력
		// SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		System.out.println(sdf.format(today));
		
		System.out.println("-----------------캘린더----------------");
		// 월은 -1 해서 관리한다.
		// 필드넘버 개념
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		// 수정
		calendar.set(2022, 2, 22);
		System.out.println(calendar);
		
		int year = calendar.get(1);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(year+"년 "+month+"월 "+date+"일");
		
		// SimpleDateFormat
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(calendar.getTime());
		
		sd.setTimeZone(TimeZone.getTimeZone("Etc/Greenwich"));
		System.out.println();
		
//		for(String name: TimeZone.getAvailableIDs()) {
//			System.out.println(name);
//		}
		
		System.out.println("------------------그레고리안");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		
		System.out.println(gc.get(GregorianCalendar.YEAR));
		System.out.println(gc.get(Calendar.HOUR_OF_DAY));
		
		// 윤년인지 확인
		System.out.println(gc.isLeapYear(2023));
	}
}
