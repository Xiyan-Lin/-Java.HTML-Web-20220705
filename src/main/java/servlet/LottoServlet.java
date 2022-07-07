package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 當 LottoServlet 繼承了 GenericServlet(通用型 Web 服務) 代表 LottoServlet 是一個 Web 服務
public class LottoServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 1. 撰寫服務商業邏輯: 自動產生四星彩電腦選號
		Random random = new Random();
		List<Integer> lotto = new ArrayList<>();
		lotto.add(random.nextInt(10)); // 0~9 的隨機數
		lotto.add(random.nextInt(10)); // 0~9 的隨機數
		lotto.add(random.nextInt(10)); // 0~9 的隨機數
		lotto.add(random.nextInt(10)); // 0~9 的隨機數
		// 2. 將 lotto 回應給 client 端
		res.setContentType("text/html;charset=utf-8");  // 回應的文件格式
		PrintWriter out = res.getWriter();  // 可寫入的回應物件
		out.print(lotto); // 撰寫回應內容
		// 3. 關閉
		out.close();
	}
	
}
