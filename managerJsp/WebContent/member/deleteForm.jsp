<%@page import="exam03.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	MemberService service = MemberService.getInstance();
	MemberVo vo = service.read(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
<h3>회원 삭제</h3>
번호: <%=vo.getNum() %>
아이디: <%=vo.getMemberId() %>
<form action="delete.jsp">
	해당 회원을 삭제하시겠습니까?<br>
	<input type="hidden" name="num" value=<%=vo.getNum() %>>
	<input type="submit" value="삭제">	
	<a href="<%=request.getContextPath() %>/member/detail.jsp?num=<%=vo.getNum() %>">취소</a>	
</form>
</body>
</html>