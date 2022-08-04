<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	${ action }<p />
	${ rowcount }
-->	
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User success</title>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="get" action="${ pageContext.request.contextPath }/users">
		<fieldset>
		 	<legend>
		 		<img src="${ pageContext.request.contextPath }/images/user.png" width="40" valign="middle">
				${ action } 成功
			</legend>	
			<button type="submit" class="pure-button pure-button-primary">回首頁</button>
		</fieldset>	
	</form>
</body>
</html>