<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	if(userId.equals(userPw)) {
		response.sendRedirect("/main.jsp");
	}else {
		response.sendRedirect("login.jsp");
	}
%>