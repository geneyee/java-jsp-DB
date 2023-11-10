<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectOne(num);
	pageContext.setAttribute("vo", vo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제하기</title>
</head>
<body>
제목 : ${vo.title }<br>
내용: ${vo.content }<br>
작성자: ${vo.writer }<br>
<form action="deleteProc.jsp">
	<input type="hidden" name="num" value=${vo.num }>
	<input type="submit" value="삭제">
	<a href="deleteForm.jsp?num=${vo.num }"><button>취소</button></a>
</form>

</body>
</html>