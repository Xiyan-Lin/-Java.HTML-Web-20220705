package jdbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.entity.User;
import jdbc.service.UserService;

@WebServlet(value = {"/users", "/user/query"})
public class QueryUserServlet extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<User> users = userService.getUsers();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/index.jsp");
		req.setAttribute("users", users);
		rd.forward(req, resp);
	}
	
}
