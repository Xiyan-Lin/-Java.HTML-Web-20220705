<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	Hello JSP <%=new Date() %><p />
	印出 1 ~ 10 <br />
	<%
		for (int i=1;i<=10;i++) {
			out.print(i);
		}
	%>
	
</body>
</html>