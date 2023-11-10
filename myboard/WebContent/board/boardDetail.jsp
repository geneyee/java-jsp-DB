<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:useBean id="dao" class="board.BoardDao" />
<%
	int num = Integer.parseInt(request.getParameter("num"));
	dao.addCnt(num);
	BoardVo vo = dao.selectOne(num);
	pageContext.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
<h3>게시글 보기</h3>
<p>제목 <input type="text" name="title" value=${vo.title } readonly="readonly"></p>
<p>작성자 <input type="text" name="writer" value=${vo.writer } readonly="readonly"></p>
<p>작성날짜 <input type="text" name="regDate" value=${vo.regDate } readonly="readonly"></p>
<p>조회수 <input type="text" name="cnt" value=${vo.cnt } readonly="readonly"></p>
<p>내용 <textarea name="content" readonly="readonly">${vo.content }</textarea></p>
<a href="<c:url value="/board/editForm.jsp?num=${vo.num}"/>"><button>수정</button></a>
<a href="deleteForm.jsp?num=${vo.num}"><button>삭제</button></a>
</body>
</html>