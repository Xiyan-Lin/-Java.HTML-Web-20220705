package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/report/*"})
public class LoginReportFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String username = req.getParameter("username");
		// username 是 admin 才可以看報表
		if(username.equals("admin")) {
			chain.doFilter(req, res); // 通過 filter 繼續往下傳遞
		} else {
			// 重導到 report_login.jsp 頁面
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/report_login.jsp");
			rd.forward(req, res);
		}
	}
	
}
