package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/report/daily", "/report/monthly"})
public class AuthCodeFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userAuthCode = request.getParameter("userAuthCode") + "";
		String authCode = request.getSession().getAttribute("authCode") + "";
		if(userAuthCode.length() > 0 && authCode.length() > 0 && authCode.equalsIgnoreCase(userAuthCode)) {
			chain.doFilter(request, response);
		} else {
			// 重導到 report_login.jsp 頁面
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/report_login.jsp");
			rd.forward(request, response);
		}
	}
	
}
