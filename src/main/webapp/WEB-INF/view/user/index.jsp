<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  
${ users }
-->
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Index</title>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/user/add">
		 <fieldset>
		 	<legend>User form</legend>
		 	Username: <input type="text" id="username" name="username" placeholder="請輸入使用者名稱" /><p />
		 	Password: <input type="password" id="password" name="password" placeholder="請輸入使用者密碼" /><p />
		 	<button type="reset" class="pure-button pure-button-primary">清除</button>
		 	<button type="submit" class="pure-button pure-button-primary">新增</button>
		 </fieldset>
	</form>
	
</body>
</html>