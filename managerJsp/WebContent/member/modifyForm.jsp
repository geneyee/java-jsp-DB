<%@page import="exam03.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
		
	MemberDao dao = new MemberDao();
	MemberService service = new MemberService(dao);
	MemberVo vo = service.read(num);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h3>회원 수정하기</h3>
	<form action="modify.jsp?num=<%=request.getParameter("num")%>" method="post" >
		<input type="text" name="memberId" value=<%=vo.getMemberId() %> readonly><br>
		<input type="password" name="memberPwOld" placeholder="기존 비밀번호" %><Br>
		<input type="password" name="memberPwNew" placeholder="새로운 비밀번호" ><Br>
		<input type="text" name="nickName" value=<%=vo.getNickName() %>><br>
		<input type="submit" value="수정"><Br>
	</form>
</body>
</html>
