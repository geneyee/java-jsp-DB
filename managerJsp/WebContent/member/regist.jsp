<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page import="exam03.*"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="vo" class="exam03.MemberVo"/>
<jsp:setProperty name="vo" property="*"/>

<%
	MemberService  memberService = MemberService.getInstance();
	
	if(memberService.regist(vo)) {
		response.sendRedirect(request.getContextPath()+"/member/index.jsp");
	}else {
		response.sendRedirect(request.getContextPath()+"/member/registForm.jsp");
	}
%>