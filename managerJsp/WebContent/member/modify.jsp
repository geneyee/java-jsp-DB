<%@page import="exam03.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>    
<jsp:useBean id="modifyRequest" class="exam03.ModifyRequest" />
<jsp:setProperty property="*" name="modifyRequest"/>
<%
	MemberService service = MemberService.getInstance();
	
	MemberVo vo = new MemberVo(
			modifyRequest.getNum(), 
			modifyRequest.getMemberId(), 
			modifyRequest.getMemberPwNew(), 
			modifyRequest.getNickName());
	if(service.edit(vo, modifyRequest.getMemberPwOld())) {
		response.sendRedirect("detail.jsp?num=" + modifyRequest.getNum());
	}else {
		System.out.println("기존 비밀번호 확인");		
		response.sendRedirect("modifyForm.jsp?num=" + modifyRequest.getNum());
	}
%>    
