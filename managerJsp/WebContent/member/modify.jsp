<%@page import="exam03.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pwOld = request.getParameter("memberPwOld");
	String memberId = request.getParameter("memberId");
	String pwNew = request.getParameter("memberPwNew");
	String nickName = request.getParameter("nickName");
	int num = Integer.parseInt(request.getParameter("num"));
	
	MemberService service = MemberService.getInstance();
	
	MemberVo vo = new MemberVo(num, memberId, pwNew, nickName);
	if(service.edit(vo, pwOld)) {
		response.sendRedirect("detail.jsp?num="+num);
	}else {
		System.out.println("기존 비밀번호 확인");		
		response.sendRedirect("modifyForm.jsp?num="+num);
	}
%>    
