<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Report Login</title>
		<script>
			function changeAuthCodeImage() {
				document.getElementById('authcodeimage').src="/JavaWeb_20220705/captcha/authcodeimage?i=" + new Date();
			}
		</script>
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="">
			<fieldset>
				<legend>Report Login 一次性</legend>
				Username: <input type="text" id="username" name="username" /><p />
				驗證授權碼: <input type="text" id="userAuthCode" name="userAuthCode" > 
				<!-- 
				<iframe valign="middle" frameborder="0" width="80" height="30" id="authcodeimage"
						src="/JavaWeb_20220705/captcha/authcodeimage" ></iframe>
				-->
				<img valign="middle" src="/JavaWeb_20220705/captcha/authcodeimage" id="authcodeimage"/>
			    <button type="button" onclick="changeAuthCodeImage()" class="pure-button pure-button-primary">更新</button><p />
				
				<button type="reset" class="pure-button pure-button-primary">重置</button>
				<button type="submit" class="pure-button pure-button-primary">傳送</button>
				
			</fieldset>
		</form>		
	</body>
</html>