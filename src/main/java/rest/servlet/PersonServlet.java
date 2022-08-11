package rest.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jpa.entity.Person;
import jpa.service.JPAService;

@WebServlet("/rest/person/*")
public class PersonServlet extends HttpServlet {
	private JPAService jpaService = new JPAService();
	private Gson gson = new Gson();
	// 一般查詢路徑範例: /rest/person/
	// 一般查詢路徑範例: /rest/person/5
	// 功能性查詢路徑範例: /rest/person/?age=30
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameterMap().size());
		// 功能性查詢
		// 功能性查詢因為一定有帶入參數, 所以 req.getParameterMap().size() 一定會 > 0
		if(req.getParameterMap().size() > 0) {
			Integer age = req.getParameter("age") == null? null : Integer.parseInt(req.getParameter("age"));
			String name = req.getParameter("name");
			if(age != null) {
				List<Person> list = jpaService.queryPersonByAge(age);
				resp.getWriter().print(gson.toJson(list)); // 將 person 轉 json 格式
				return;
			}
			if(name != null) {
				List<Person> list = jpaService.findByName("%" + name + "%");
				resp.getWriter().print(gson.toJson(list)); // 將 person 轉 json 格式
				return;
			}
			return;
		}
		
		// 一般查詢
		Integer id = checkPath(req); 
		if(id == null) {
			// 多筆查詢
			List<Person> list = jpaService.queryAllPerson(); // 取得所有 person 資料
			resp.getWriter().print(gson.toJson(list)); // 將 person 轉 json 格式
		} else {
			// 單筆查詢
			Person person = jpaService.getPerson(id);
			resp.getWriter().print(gson.toJson(person)); // 將 person 轉 json 格式
		}
	}
	
	// 路徑範例: /rest/person/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(checkPath(req) != null) return;
		// 取得資料
		String name = req.getParameter("name");
		Integer age = req.getParameter("age") == null ? 0 : Integer.parseInt(req.getParameter("age"));
		// person 物件封裝
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		// 新增
		jpaService.addPerson(person);
		resp.getWriter().print(gson.toJson(person));
		
	}
	
	// 路徑範例: /rest/person/2
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req);
		if(id == null) return;
		
		// 自行分解串流資料
		// byte[] -> char[] -> String
		ServletInputStream sis = req.getInputStream(); // byte[]
		InputStreamReader isr = new InputStreamReader(sis); // byte[] 轉 char[]
		BufferedReader br = new BufferedReader(isr); // char[] 轉 String
		String args = br.readLine(); // String
		// 範例: name=UUU&age=19
		// 轉 Map
		Map<String, String> map = new LinkedHashMap<>();
		for(String str : args.split("&")) {
			String[] array = str.split("=");
			map.put(array[0], array[1]);
		}
				
		String name = map.get("name");
		Integer age = map.get("age") == null ? 0 : Integer.parseInt(map.get("age"));
		
		// 修改
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setAge(age);
		jpaService.updatePerson(person);
		resp.getWriter().print(gson.toJson(person));
		
//		resp.getWriter().println("單筆修改, id=" + id + ", name=" + name + ", age=" + age);
//		resp.getWriter().println("args=" + args);
//		resp.getWriter().println("map=" + map);
	}
	
	// 路徑範例: /rest/person/3
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = checkPath(req);
		if(id == null) return;
		
		jpaService.deletePerson(id);
		resp.getWriter().println(id);
	}
	
	private Integer checkPath(HttpServletRequest req) {
		String servletPath = req.getServletPath();
		String pathInfo = req.getPathInfo();
		System.out.println("servletPath = " + servletPath);
		System.out.println("pathInfo = " + pathInfo);
		if (pathInfo.length() == 1 && pathInfo.charAt(0) == '/') {
			return null;
		} else if(pathInfo.length() > 1 && pathInfo.charAt(0) == '/') {
			Integer id = Integer.parseInt(pathInfo.replace("/", ""));
			return id;
		}
		return null;
	}
	
	
}
