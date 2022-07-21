<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>Coffee Form</title>
	</head>
	<body>
		<body style="padding: 15px">
		<form class="pure-form" method="post" action="/JavaWeb_20220705/coffee/session">
			<fieldset>
				<legend>Coffee Form</legend>
				Amount: <input type="number" value="${ sessionScope['amount'] }" placeholder="請輸入數量" name="amount" /><p />
				<button type="reset" class="pure-button pure-button-primary">重置</button>
				<button type="submit" class="pure-button pure-button-primary">買入</button>
				<button type="button" 
						onclick="location.href='/JavaWeb_20220705/coffee/session/invalidate';"
						class="pure-button pure-button-primary">失效</button>
			</fieldset>
		</form>		
	</body>
</html>