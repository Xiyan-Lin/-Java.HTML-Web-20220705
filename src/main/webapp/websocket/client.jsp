<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>WebSocket Client</title>
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form" id="chatRoomForm" onsubmit="return false;">
			<fieldset>
				<legend>WebSocket Client</legend>
				姓名: <input type="text" id="username" placeholder="請輸入名稱" required="required" />
				<button type="button" class="pure-button pure-button-primary" id="loginBtn">登入</button>
				<p />
				訊息: <input type="text" id="message" placeholder="請輸入訊息" required="required" />
				<button type="submit" class="pure-button pure-button-primary" id="submitBtn">傳送</button>
				<p />
			</fieldset>
		</form>
		
		<div id="messageDisplay"></div>
		
	</body>
</html>