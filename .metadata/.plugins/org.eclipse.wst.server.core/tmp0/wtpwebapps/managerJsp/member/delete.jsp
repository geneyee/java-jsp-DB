<%@page import="exam03.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	MemberService service= new MemberService(new MemberDao());
	if(service.remove(num)) {
		response.sendRedirect(request.getContextPath()+"/member/list.jsp");
	}else {
		response.sendRedirect(request.getContextPath()+"/member/detail.jsp?num=" + num);
	}
%>