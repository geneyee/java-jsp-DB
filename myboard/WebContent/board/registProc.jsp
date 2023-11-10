<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<% request.setCharacterEncoding("UTF-8"); %> 
<jsp:useBean id="vo" class="board.BoardVo" />
<jsp:useBean id="dao" class="board.BoardDao" />
<jsp:setProperty name="vo" property="*" />
  
<%
	dao.insertBoard(vo);
	response.sendRedirect(request.getContextPath()+"/board/list.jsp");
	
%>
<%-- <c:redirect url="/board/list.jsp"></c:redirect> 
--%>