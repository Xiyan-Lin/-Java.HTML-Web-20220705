package upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/upload")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2, // 2MB
		maxFileSize = 1024*1024*10, // 10MB
		maxRequestSize = 1024*1024*50 // 50MB
)
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
		// 找到 pname, price
		req.getParts().stream()
			.filter(part -> part.getName().equals("pname") || part.getName().equals("price"))
			.forEach(part -> {
				try {
					String value = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
					out.println(part.getName() + " = " + value);
					out.println("<p />");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		
		// 找到 file1
		req.getParts().stream()
			.filter(part -> part.getName().equals("file1"))
			.forEach(part -> {
				try {
					// 將上傳的圖片以 base64 的編碼方式製作成 base64 圖片碼
					// 製作步驟: InputStream -> byte[] -> base64 字串
					InputStream is = part.getInputStream();
					byte[] bytes = IOUtils.toByteArray(is);
					String base64 = Base64.getEncoder().encodeToString(bytes);
					// 建立 HTML <img src='data:image/png;base64, %s'> 標籤
					String imgHtml = "<img src='data:image/png;base64, %s'>";
					imgHtml = String.format(imgHtml, base64);
					// 圖片名字
					String imageName = part.getSubmittedFileName(); // 取得 client 端上傳的檔名
					out.println("imageName = " + imageName);
					out.println("<br />");
					// 圖片呈現
					out.println(imgHtml);
					// 存檔前檢查 C:/upload 是否存在 ?
					File file = new File("C:/upload");
					if(!file.exists()) { // 若 C:/upload 不存在
						file.mkdir(); // 建立 C:/upload 資料夾
					}
					// 圖片存檔
					part.write(file.toString() + "/" + imageName);
					out.println("圖片存檔至 C:/upload 成功 !");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		
			
	}
	
	// 處理上傳後的程序
	/*
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
	*/
	
}
