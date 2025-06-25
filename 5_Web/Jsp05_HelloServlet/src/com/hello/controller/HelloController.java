package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//hello 라는 요청이 클라이언트로부터 넘어오면 실행되는 서클릿
@WebServlet("/hi")
public class HelloController extends HttpServlet{
	private String contextParam;
	private String initParam;
	
	public HelloController() {
		System.out.println("HelloController 서블릿 생성자");
	}
	
	@Override
	public void init(ServletConfig config) {
		// 서블릿 객체가 생성될 때 초기화 할 수 있는 메소드
		contextParam = config.getServletContext().getInitParameter("url");
		System.out.println(contextParam);
		
		initParam = config.getInitParameter("id");
		System.out.println("initParam : "+initParam);
	}
	
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
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command : "+command);
		
		response.sendRedirect("Test.jsp");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 종료!!!!");  
	}
}
