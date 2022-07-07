package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//當 TodayServlet 繼承了 HttpServlet(HTTP 型 Web 服務) 代表 TodayServlet 是一個 HTTP Web 服務
public class TodayServlet extends HttpServlet {

	// 服務 GET 請求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		String today = sdf.format(date);
		System.out.println(today); // 顯示在 Server 端的 Console 中 (debug 用)
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<H1>");
		out.print(today);
		out.print("</H1>");
	}
	
}
