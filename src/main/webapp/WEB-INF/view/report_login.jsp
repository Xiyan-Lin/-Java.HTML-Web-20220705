<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Report Login</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="">
			<fieldset>
				<legend>Report Login 一次性</legend>
				Username: <input type="text" id="username" name="username" /><p />
				驗證授權碼: <input type="text" id="userAuthCode" name="userAuthCode" > 
				<img valign="middle" src="/JavaWeb_20220705/captcha/authcodeimage" /><p />
				<button type="reset" class="pure-button pure-button-primary">重置</button>
				<button type="submit" class="pure-button pure-button-primary">傳送</button>
			</fieldset>
		</form>		
	</body>
</html>