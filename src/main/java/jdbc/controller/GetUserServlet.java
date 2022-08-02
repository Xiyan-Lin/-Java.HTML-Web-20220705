package jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.entity.User;
import jdbc.service.UserService;

@WebServlet("/user/get")
public class GetUserServlet extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		User user = userService.getUser(id);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/update.jsp");
		req.setAttribute("user", user);
		rd.forward(req, resp);
	}
	
}
