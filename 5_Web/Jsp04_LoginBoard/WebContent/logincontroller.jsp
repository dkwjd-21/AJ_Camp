<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="com.login.dto.MyMemberDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command : "+command+" ]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id, pw);
		
		if(dto.getMyid() != null){
			// 로그인 성공
			// session 객체 : 브라우저당 1개의 session 객체가 생성
			session.setAttribute("dto", dto);
			// 객체를 얼마나 살려둘 건가 (시간)
			session.setMaxInactiveInterval(60*60);	// 60초*60 => 1시간
			// 1시간 지나면 다시 로그인 해야됨 
			// default : 30분 
			
			// Scope : 객체들의 공유 범위
			// 1. page 영역 : 하나의 jsp 페이지 내에서만 객체를 공유함 
			// 2. request 영역 : forward를 통해 request객체가 공유됨 
			// 3. session 영역 : 같은 브라우저 내에서의 페이지들은 같은 session 객체를 공유한다.
			// 4. application 영역 : 하나의 어플리케이션 당 1개의 application 객체를 생성하고 공유한다.
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			} else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}			
		} else {
			// 로그인 실패 
			request.setAttribute("msg", "login 실패");
			request.setAttribute("url", "index.jsp");
			pageContext.forward("result.jsp");
		}
	}else if(command.equals("logout")){
		// session에 저장된 정보를 삭제 
		session.invalidate();
		request.setAttribute("msg", "로그아웃");
		request.setAttribute("url", "index.jsp");
		pageContext.forward("result.jsp");
	} else if(command.equals("userlistAll")){
		List<MyMemberDto> list = dao.selectAll();
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
	} else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
	} else if(command.equals("idchk")){
		String myid = request.getParameter("id");
		// res가 null이다 => db에 없는 값이다!  
		//		!null 	=> 이미 해당 아이디로 저장된 회원이 있다. 중복이다!
		String res = dao.idChk(myid);
		boolean idnotused = true;
		if(res != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
		
	} else if(command.equals("insertmember")){
		// 파라미터로 넘어오는 데이터를 받은 후
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		// dao를 통해 insert() 실행 
		// 그 결과를 통해 화면 처리 
		MyMemberDto dto = new MyMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		// dao를 통해 insert() 실행
		int res = dao.insertMember(dto);
		
		// 그 결과를 통해 화면 처리
		String msg = "";
		String url = "";
		
		if(res>0){
			msg = "회원 가입 성공";
			url = "index.jsp";
		} else {
			msg = "회원 가입 실패";
			url = "logincontroller.jsp?command=registform";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		pageContext.forward("result.jsp");
	}
%>
</body>
</html>