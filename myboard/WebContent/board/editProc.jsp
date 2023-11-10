<%@page import="board.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="modifyRequest" class="board.ModifyRequest"/>
<jsp:setProperty property="*" name="modifyRequest"/>
<%
	System.out.println("수정 vo : "+modifyRequest.toString());

	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = new BoardVo(
			modifyRequest.getNum(), 
			modifyRequest.getTitle(),
			modifyRequest.getContent());
	dao.updateBoard(vo);
	response.sendRedirect(request.getContextPath()+"/board/boardDetail.jsp?num="+vo.getNum());
%>