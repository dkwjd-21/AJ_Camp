package com.bye.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ByeController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException{
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>HelloServlet</h1>");
		out.print("<span>서블릿 연습</span>");
		out.print("<a href='home.html'>돌아가기</a>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command : "+command);
	}
}
