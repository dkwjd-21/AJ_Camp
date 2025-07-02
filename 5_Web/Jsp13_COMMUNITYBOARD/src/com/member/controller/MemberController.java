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
			
			MemberDto res = dao.selectOne(id);
			
			if(res != null) {
				// 선택해온 dto가 null이 아니고 비밀번호가 일치할 때 로그인 성공 
				if(res.getPw().equals(pw) && res.getEnabled()=='Y') {
					session.setAttribute("member", res);
					System.out.println("로그인 성공!");
					response.sendRedirect("board?command=list");
					
				} else if(!res.getPw().equals(pw)){
					System.out.println("로그인 실패ㅠㅠ.. (비밀번호 오입력)");
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().println("<script>");
					response.getWriter().println("alert('비밀번호가 틀렸습니다!');");
					response.getWriter().println("history.back();");
					response.getWriter().println("</script>");
				} else if(res.getEnabled()!='Y') {
					System.out.println("로그인 실패ㅠㅠ.. (탈퇴된 계정)");
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().println("<script>");
					response.getWriter().println("alert('탈퇴된 계정입니다!');");
					response.getWriter().println("history.back();");
					response.getWriter().println("</script>");
				}
			} else {
				System.out.println("로그인 실패ㅠㅠ.. (아이디 오입력)");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('아이디를 정확히 입력해주세요!');");
				response.getWriter().println("history.back();");
				response.getWriter().println("</script>");
			}
			
		} else if(command.equals("signupform")) {
			// 회원가입 폼 
			response.sendRedirect("signupform.jsp");
			
		} else if(command.equals("signup")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			MemberDto dto = new MemberDto();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPhone(phone);
			
			int res = dao.signup(dto);
			
			String msg, url; 
			
			if(res>0) {
				msg = "가입 성공!";
				url = "index.html";
			} else {
				msg = "가입 실패ㅠㅠ..";
				url = "index.html";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("mypage")) {
			// mypage 정보 
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			request.setAttribute("member", member);
			RequestDispatcher dis = request.getRequestDispatcher("mypage.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("signout")) {
			// 탈퇴하기 - UPDATE ENABLED 
			int no = Integer.parseInt(request.getParameter("no"));
			
			int res = dao.signout(no);
			
			String msg, url; 
			
			if(res>0) {
				msg = "탈퇴 성공!";
				url = "index.html";
			} else {
				msg = "탈퇴 실패ㅠㅠ..";
				url = "board?command=list";
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
