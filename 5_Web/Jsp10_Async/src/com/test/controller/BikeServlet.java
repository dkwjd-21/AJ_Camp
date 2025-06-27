package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/bike.do")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("command: "+command);
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
			
		} else if(command.equals("second")) {
			response.sendRedirect("bike02.jsp");
			
		} else if(command.equals("second_db")) {
			String obj = request.getParameter("obj");
//			System.out.println("obj: "+obj);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			// DATA의 첫번째 방에 저장된 json 데이터 new_addr 값 저장하기
			String str = element.getAsJsonObject().get("DATA").
								 getAsJsonArray().get(0).getAsJsonObject().
								 get("new_addr").getAsString();
			System.out.println("첫번째 new_addr: "+str);
			
			// DESCRIPTION이 가지는 data의 ADDR_GU의 값을 String으로 저장하기
			str = element.getAsJsonObject().get("DESCRIPTION").
						  getAsJsonObject().get("ADDR_GU").getAsString();
			System.out.println("DESCRIPTION의 ADDR_GU: "+str);
			
			System.out.println("------------------------------");
			
			// 데이터가 가지고 있는 배열의 크기만큼 반복. 
			for(int i=0; i<element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i+=300) {
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				System.out.println(tmp.get("new_addr").getAsString());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
