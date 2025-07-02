package com.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dao.MemberDao;
import com.member.dto.MemberDto;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[Member] command : "+command);
		
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		
		if(command.equals("login")) {
			// 로그인 
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDto dto = dao.selectOne(id);
			
			// 비밀번호가 틀렸을 경우
			if(!dto.getPw().equals(pw)) {
				System.out.println("로그인 실패ㅠㅠ.. (비밀번호 오입력)");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('비밀번호가 틀렸습니다!');");
				response.getWriter().println("history.back();");
				response.getWriter().println("</script>");
			} else {
			// 로그인 성공!
				System.out.println("로그인 성공!");
				session.setAttribute("user", dto);
			}	response.sendRedirect("feed.jsp");
			
		} else if(command.equals("signupform")) {
			// 회원가입 폼으로 이동
			response.sendRedirect("signupform.jsp");
			
		} else if(command.equals("signup")) {
			// 회원가입
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPhone(phone);
			dto.setEmail(email);
			
			int res = dao.signup(dto);
			
			String msg, url;
			
			if(res>0) {
				msg = "회원가입 성공!";
				url = "index.html";
			} else {
				msg = "회원가입 실패..";
				url = "index.html";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
