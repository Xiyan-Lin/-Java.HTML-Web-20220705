package jpa.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.entity.Employee;
import jpa.service.JPAService;
import jpa.util.DESEncryptService;

/*
 * GET /jpa/employee/
 * GET /jpa/employee/251?password=1234 (會得到此人的 salary 資料)
 * */
@WebServlet("/jpa/employee/*")
public class JPAEmployeeServlet extends HttpServlet {
	
	private JPAService jpaService = new JPAService();
	
	private Integer getId(HttpServletRequest req) {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.replace("/", "");
		return pathInfo.matches("[0-9]+")?Integer.parseInt(pathInfo):null;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = getId(req);
		if(id != null) {
			String password = req.getParameter("password");
			// 將 password 進行 MD5 加密
			try {
				// 將使用者所輸入的密碼加密
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				byte[] result = md5.digest(password.getBytes()); // password 資料加密
				String md5_password = String.format("%032X", new BigInteger(result));
				
				// 取得該使用者存在資料庫的資料
				Employee employee = jpaService.getEmployee(id);
				
				// 密碼比對
				if(md5_password.equals(employee.getPassword())) {
					// 進行 salary 解密程序
					String key_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/key/user.key";
					DESEncryptService des = new DESEncryptService(key_path);
					String salary = new String(des.decryptor(employee.getSalary())); // 解密
					resp.getWriter().print(salary);
				} else {
					resp.getWriter().print("fail");
				}
				
			} catch (Exception e) {
				resp.getWriter().print(e);
			}
		}
	}
	
}
