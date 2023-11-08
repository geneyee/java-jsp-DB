<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 폼</title>
</head>
<body>
<h3>회원 등록 하기</h3>
<form action="<%= request.getContextPath() %>/member/regist.jsp" method="post">
	<input type="text" name="memberId" placeholder="아이디"><br>
	<input type="password" name="memberPw" placeholder="비밀번호"><Br>
	<input type="text" name="nickName" placeholder="닉네임"><br>
	<input type="submit" value="등록"><Br>
</form>
</body>
</html>