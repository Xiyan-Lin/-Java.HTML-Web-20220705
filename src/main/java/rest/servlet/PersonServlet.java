package rest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest/person/*")
public class PersonServlet extends HttpServlet {
	// 路徑範例: /rest/person/
	// 路徑範例: /rest/person/5
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req); 
		if(id == null) {
			resp.getWriter().println("多筆查詢");
		} else {
			resp.getWriter().println("單筆查詢, id=" + id);
		}
		
	}
	
	// 路徑範例: /rest/person/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(checkPath(req) != null) return;
		
		resp.getWriter().print("單筆新增");
		
	}
	
	// 路徑範例: /rest/person/2
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req);
		if(id == null) return;
		
		resp.getWriter().println("單筆修改, id=" + id);
	}
	
	// 路徑範例: /rest/person/3
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req);
		if(id == null) return;
		
		resp.getWriter().println("單筆刪除, id=" + id);
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
