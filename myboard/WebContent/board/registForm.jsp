<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
input {
	border: 1px solid #000;
}
textarea {
	width: 80%;
	height: 100px;
}
</style>
</head>
<body>
<h3>글쓰기</h3>
<form action="registProc.jsp" method="post">
	<input type="text" name="title" placeholder="제목을 입력하세요." required><br>
	<input type="text" name="writer" placeholder="작성자를 입력하세요." required><br>
	<textarea name="content" placeholder="내용을 입력하세요."></textarea><br>
	<input type="submit" value="글쓰기">
</form>
</body>
</html>