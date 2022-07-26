package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
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
			// 得到 request URL
			System.out.println(request.getRequestURL());
			response.sendRedirect(request.getRequestURL().toString());
		}
	}
	
}
