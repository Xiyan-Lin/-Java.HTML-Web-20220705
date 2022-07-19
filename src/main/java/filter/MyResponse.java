package filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

// 自訂一個 Response 物件
public class MyResponse extends HttpServletResponseWrapper {
	private PrintWriter out;
	private CharArrayWriter bufferedWriter; // 放置 HTML 的地方
	
	public MyResponse(HttpServletResponse response) {
		super(response);
		bufferedWriter = new CharArrayWriter();
		out = new PrintWriter(bufferedWriter);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return out;
	}
	
	public String getHTMLSource() {
		return bufferedWriter.toString();
	}
	
	
}
