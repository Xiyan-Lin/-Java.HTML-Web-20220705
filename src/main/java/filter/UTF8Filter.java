package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 定義要過濾的路徑
//@WebFilter(urlPatterns = {"/report/daily", "/report/monthly"})
@WebFilter(urlPatterns = {"/report/*", "/servlet/upload", "/rest/*", "/webapi/*"})
public class UTF8Filter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// UTF-8 配置
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 往下傳送
		chain.doFilter(request, response);
		
	}
	
}
