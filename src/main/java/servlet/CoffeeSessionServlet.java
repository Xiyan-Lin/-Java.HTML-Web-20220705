package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Coffee;

@WebServlet("/coffee/session")
public class CoffeeSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			String amount = session.getAttribute("amount") + "";
			resp.getWriter().print("Coffee amount: " + amount);
			resp.getWriter().print(" session id = " + session.getId());
		} else {
			resp.getWriter().print("Coffee amount: None");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amount = req.getParameter("amount");
		HttpSession session = req.getSession(true);
		Coffee coffee = new Coffee();
		coffee.setAmount(Integer.valueOf(amount));
		session.setAttribute("amount", coffee);
		resp.getWriter().print("Buy Coffee OK!");
		resp.getWriter().print(" session id = " + session.getId());
	}
	
}
