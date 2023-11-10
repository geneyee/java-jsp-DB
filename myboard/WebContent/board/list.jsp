<%@page import="java.util.List"%>
<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	BoardDao dao = BoardDao.getInstance();
	List<BoardVo> list = dao.selectAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>
<h2>게시글 목록</h2>
<table border="1">
<% 
	if(list.size() == 0){
%>
	<tr>
		<td>목록이 없습니다.</td>
	</tr>
<% 		
	} else {
%>
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.num }</td>
				<td><a href="boardDetail.jsp?num=${board.num}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%	} // else end %> 
<a href="registForm.jsp"><button>글쓰기</button></a>
</body>
</html>