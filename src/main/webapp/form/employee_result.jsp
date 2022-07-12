<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>員工資料表單回應</title>
		<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<form class="pure-form">
			<fieldset>
				<legend>員工資料表單回應</legend>
				姓名: ${ empName }<p />
				年齡: ${ empAge }<p />
				性別: ${ empSex }<p />
				階級: ${ empPos }<p />
				生日: ${ empBirth }<p />
				程式: ${ empLang }<p />
				備註: ${ empMemo }<p />
				<button type="button" class="pure-button pure-button-primary" onclick="history.back()">返回</button>
			</fieldset>
		</form>
	</body>
</html>
