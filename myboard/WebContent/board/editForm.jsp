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
<title>게시글 수정</title>
</head>
<body>
<h3>게시글 수정</h3>
<form action="editProc.jsp" method="post">
	<input type="hidden" id="num" name="num" value=${vo.num }><br>
	제목 <input type="text" name="title" value=${vo.title }><br>
	작성자 <input type="text" name="writer" value=${vo.writer } disabled><br>
	내용 <textarea name="content" placeholder="내용을 입력하세요.">${vo.content }</textarea><br>
	<input type="submit" value="수정하기">
</form>
</body>
</html>