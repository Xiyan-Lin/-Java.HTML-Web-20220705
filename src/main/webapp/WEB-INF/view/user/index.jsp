<%@page import="jdbc.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<!--  
${ users }
-->
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Index</title>
	<script>
		function deleteUserById(id) {
			if(confirm('是否要刪除 id:' + id + ' 的資料 ?')) {
				
			}
		}
	</script>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="post" action="${ pageContext.request.contextPath }/user/add">
		 <fieldset>
		 	<legend>
		 		<img src="${ pageContext.request.contextPath }/images/user.png" width="40" valign="middle"> 
		 		User form
		 	</legend>
		 	Username: <input type="text" id="username" name="username" placeholder="請輸入使用者名稱" /><p />
		 	Password: <input type="password" id="password" name="password" placeholder="請輸入使用者密碼" /><p />
		 	<button type="reset" class="pure-button pure-button-primary">清除</button>
		 	<button type="submit" class="pure-button pure-button-primary">新增</button>
		 </fieldset>
	</form>
	<form class="pure-form">
		<fieldset>
		 	<legend>
		 		<img src="${ pageContext.request.contextPath }/images/users.png" width="40" valign="middle"> 
		 		User list
		 	</legend>
		 	<table class="pure-table pure-table-bordered">
		 		<thead>
		 			<tr>
		 				<th>id</th>
		 				<th>username</th>
		 				<th>password(decode)</th>
		 				<th>createtime</th>
		 				<th>update</th>
		 				<th>delete</th>
		 			</tr>
		 		</thead>
		 		<tbody>
		 			<c:forEach var="user" items="${ users }">
		 				<tr>
		 					<td>${ user.id }</td>
		 					<td>${ user.username }</td>
		 					<td>${ user.password }</td>
		 					<td>${ user.createtime }</td>
		 					<td><a href="${ pageContext.request.contextPath }/user/get?id=${ user.id }">修改</a></td>
		 					<td><a href="#" onclick="deleteUserById(${ user.id })">刪除</a></td>
		 				</tr>
		 			</c:forEach>
		 		</tbody>
		 	</table>
		</fieldset> 	
	</form>
	
</body>
</html>