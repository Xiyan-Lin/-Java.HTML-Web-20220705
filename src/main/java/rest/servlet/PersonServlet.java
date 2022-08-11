package rest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest/person/*")
public class PersonServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req); 
		if(id == null) {
			resp.getWriter().println("多筆查詢");
		} else {
			resp.getWriter().println("單筆查詢, id=" + id);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("doPost()");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("doPut()");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("doDelete()");
	}
	
	private Integer checkPath(HttpServletRequest req) {
		String servletPath = req.getServletPath();
		String pathInfo = req.getPathInfo();
		System.out.println("servletPath = " + servletPath);
		System.out.println("pathInfo = " + pathInfo);
		if (pathInfo.length() == 1 && pathInfo.charAt(0) == '/') {
			return null;
		} else if(pathInfo.length() > 1 && pathInfo.charAt(0) == '/') {
			Integer id = Integer.parseInt(pathInfo.replace("/", ""));
			return id;
		}
		return null;
	}
	
	
}
