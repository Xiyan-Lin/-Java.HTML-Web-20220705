package websocket;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
class Client {
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client 已進入, session id: " + session.getId());
	}
	
	@OnMessage // 接收訊息
	public void onMessage(String message, Session session) {
		System.out.println("接收訊息: " + message);
	}
}

public class SimpleClient {
	public static void main(String[] args) throws Exception {
		// 設定 WebSocket Endpoint 位置
		URI uri = new URI("http://localhost:8080/JavaWeb_20220705/websocket_endpoint");
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		Session session = container.connectToServer(new Client(), uri);
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入訊息(q 離開): ");
			String msg = scanner.next();
			if(msg.trim().equalsIgnoreCase("q")) {
				session.close();
				break;
			}
			session.getAsyncRemote().sendText("Java 說: " + msg.trim());
		}
	}
}

