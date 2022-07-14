<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
		<meta charset="UTF-8">
		<title>匯率換算結果</title>
	</head>
	<body style="padding: 15px">
		<form class="pure-form">
			<fieldset>
				<legend>匯率換算結果</legend>
				金額: ${ exchange.amount }<p />
				換匯: ${ exchange.from } 轉 ${ exchange.to }<p />
				匯率: ${ exchange.exchange }<p />
				日期: ${ exchange.datetime }<p />
				結果: ${ exchange.result }<p />
				<button type="button" class="pure-button pure-button-primary" onclick="history.back()">返回</button>
			</fieldset>
		</form>
	</body>
</html>