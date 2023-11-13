<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDao dao = BoardDao.getInstance();
	dao.deleteBoard(num);
	
	response.sendRedirect(request.getContextPath()+"/board/list.jsp");
%>