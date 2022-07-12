package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 此程式要將放在 C:\Users\MB-207\Pictures\alpha.jpg 圖片顯示給前端瀏覽器
// 瀏覽器可以透過 http://localhost:8080/JavaWeb_20220705/servlet/image/alpha 得到此圖
//@WebServlet(urlPatterns = "/servlet/image/alpha")
@WebServlet("/servlet/image/alpha")
public class AlphaImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");
		String imagePath = "C:/Users/MB-207/Pictures/alpha.jpg";
		File file = new File(imagePath);
		ServletOutputStream out = resp.getOutputStream();
		//        (圖片來源端,     目的端)
		Files.copy(file.toPath(), out);
		out.close();
	}
	
}
