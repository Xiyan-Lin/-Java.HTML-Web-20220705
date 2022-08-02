package jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.service.UserService;

@WebServlet("/user/update")
public class UpdateUserServlet extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int rowcount = userService.update(id, username, password);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/success.jsp");
		req.setAttribute("action", "update");
		req.setAttribute("rowcount", rowcount);
		rd.forward(req, resp);
	}
	
}
