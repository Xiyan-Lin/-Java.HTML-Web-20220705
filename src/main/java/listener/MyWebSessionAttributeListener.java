package listener;

import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyWebSessionAttributeListener implements HttpSessionAttributeListener {
	// 印出要監聽的內容
	private void printInfo(HttpSession session, String message) {
		System.out.println(message + ": " + session.getAttributeNames());
		Enumeration<String> names = session.getAttributeNames(); // 透過 session.setAttribute(xxx) 所設定的名字集合
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.printf("%s = %s\n", name, session.getAttribute(name));
		}
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		printInfo(event.getSession(), "attributeAdded");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		printInfo(event.getSession(), "attributeReplaced");
	}
	
}
