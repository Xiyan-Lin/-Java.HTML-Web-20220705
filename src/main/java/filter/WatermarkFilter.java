package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/report/*")
public class WatermarkFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 建立自己的 Response 物件
		MyResponse myResponse = new MyResponse(res);
		
		// 傳遞
		chain.doFilter(req, myResponse);
		
		// 回應時
		// 取得 HTML
		String html = myResponse.getHTMLSource();
		// 在 html 中加入浮水印
		html = "<body background='/JavaWeb_20220705/images/copy.jpg'>" + html + "</body>";
		// 將資料重寫給瀏覽器
		res.getWriter().print(html);	   	
	}
	
}
