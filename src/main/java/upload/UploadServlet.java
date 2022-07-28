package upload;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/upload")
public class UploadServlet extends HttpServlet {
	
	// 顯示/重導指定上傳的 JSP 頁面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/upload_form.jsp");
		rd.forward(req, resp);
	}
	
	// 處理上傳後的程序
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// 顯示上傳的 Header 資訊 (HTTP 文件第二部分)
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement(); // 取得標頭名稱
			String headerValue = req.getHeader(headerName);
			out.print(headerName + "=" + headerValue);
			out.println("<br />");
		}
		out.println("<hr>");
		// 顯示上傳的內容 (HTTP 文件第四部分)
		InputStreamReader isr = new InputStreamReader(req.getInputStream());
		char[] buffer = new char[1];
		while(isr.read(buffer) != -1) {
			out.print(buffer);
		}
		out.println("<hr>");
	}
	
}
