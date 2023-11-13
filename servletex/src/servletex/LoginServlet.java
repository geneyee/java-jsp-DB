package servletex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("로그인 서블릿 초기화");
	}
	
	@Override
	public void destroy() {
		System.out.println("로그인 서블릿 소멸");
	}
	
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { super.service(req, resp);
	 * System.out.println("로그인 서비스!"); }
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO get method
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO post method
		
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
		if(userId.equals(userPw)) {
			resp.sendRedirect("/main.jsp");
			System.out.println("로그인 성공!");
		}else {
			resp.sendRedirect("/login.jsp");
			System.out.println("로그인 실패!");
		}
	}
}
