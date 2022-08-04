<%@page import="jdbc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<!--  
${ user }
-->
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Update</title>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/user/update">
		 <fieldset>
		 	<legend>
		 		<img src="${ pageContext.request.contextPath }/images/user.png" width="40" valign="middle"> 
		 		User form (Update)
		 	</legend>
		 	<!-- 利用隱藏欄位來放置 user.id -->
		 	<input type="hidden" name="id" value="${ user.id }">
		 	Username: <input type="text" id="username" name="username" placeholder="請輸入使用者名稱" value="${ user.username }" /><p />
		 	Password: <input type="password" id="password" name="password" placeholder="請輸入使用者密碼" value="${ user.password }" /><p />
		 	<button type="button"
		 			onclick="window.location.href='${ pageContext.request.contextPath }/users';" 
		 			class="pure-button pure-button-primary">回首頁</button>
		 	<button type="reset" class="pure-button pure-button-primary">清除</button>
		 	<button type="submit" class="pure-button pure-button-primary">修改</button>
		 </fieldset>
	</form>
	
</body>
</html>