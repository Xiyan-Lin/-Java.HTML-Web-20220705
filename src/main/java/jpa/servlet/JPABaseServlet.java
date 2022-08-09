package jpa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jpa.service.JPAService;

public class JPABaseServlet extends HttpServlet {
	
	private JPAService jpaService;

	@Override
	public void init() throws ServletException {
		super.init();
		jpaService = new JPAService();
	}
	
	public JPAService getJPAService() {
		return jpaService;
	}
}
