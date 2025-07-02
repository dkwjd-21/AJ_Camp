package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.member.dto.MemberDto;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[Board] command : "+command);
		
		BoardDao dao = new BoardDao();
		
		HttpSession session = request.getSession();
		if(command.equals("list")) {
			// 글 전체보기
			
			List<BoardDto> list = dao.selectAll();
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			request.setAttribute("member", member);
			request.setAttribute("list", list);
			RequestDispatcher dis = request.getRequestDispatcher("boardlist.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("detail")) {
			// 글 하나만 보기 
			int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDto dto = dao.selectOne(no);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("insertform")) {
			response.sendRedirect("insertform.jsp");
			
		} else if(command.equals("insert")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			BoardDto dto = new BoardDto();
			dto.setName(member.getName());
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.insert(dto);
			
			String msg, url;
			
			if(res>0) {
				msg = "작성 성공!";
				url = "board?command=list";
			} else {
				msg = "작성 실패ㅠㅠ..";
				url = "board?command=list";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("updateform")) {
			// 업데이트 폼 
			String writer = request.getParameter("writer");	// 글 작성자
			int no = Integer.parseInt(request.getParameter("no"));
			
			MemberDto member = (MemberDto)session.getAttribute("member");
			BoardDto dto = dao.selectOne(no);
			
			if(writer.equals(member.getName())) {
				// 작성자와 로그인한 사람이 같을 경우만 수정 가능
				request.setAttribute("dto", dto);
				
				RequestDispatcher dis = request.getRequestDispatcher("updateform.jsp");
				dis.forward(request, response);
				
			} else {
				System.out.println("수정 실패.. (작성자 본인이 아님)");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('작성자 본인만 수정할 수 있습니다.');");
				response.getWriter().println("history.back();");
				response.getWriter().println("</script>");
			}
			
		} else if(command.equals("update")) {
			// 업데이트
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDto dto = new BoardDto();
			dto.setNo(no);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = dao.update(dto);
			String msg, url;
			
			
			if(res>0) {
				msg = "수정 성공!";
				url = "board?command=list";
			} else {
				msg = "수정 실패ㅠㅠ..";
				url = "board?command=list";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
			dis.forward(request, response);
			
		} else if(command.equals("delete")) {
			// 글 삭제 
			String writer = request.getParameter("writer");	// 글 작성자
			int no = Integer.parseInt(request.getParameter("no"));
						
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			if(writer.equals(member.getName())) {
				// 작성자 본인만 삭제 가능
				int res = dao.delete(no);
				String msg, url;
				
				if(res>0) {
					msg = "삭제 성공!";
					url = "board?command=list";
				} else {
					msg = "삭제 실패ㅠㅠ..";
					url = "board?command=list";
				}
				
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
				dis.forward(request, response);
				
			} else {
				System.out.println("삭제 실패.. (작성자 본인이 아님)");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('작성자 본인만 삭제할 수 있습니다.');");
				response.getWriter().println("history.back();");
				response.getWriter().println("</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
