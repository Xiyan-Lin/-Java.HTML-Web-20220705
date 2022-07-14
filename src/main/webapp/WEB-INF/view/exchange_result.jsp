<%@ page import="java.util.List"%>
<%@ page import="mvc.entity.Exchange"%>
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
				換匯: ${ exchange.from } 轉 ${ exchange.to }<p />
				金額: ${ exchange.from } ${ exchange.amount }<p />
				結果: ${ exchange.to } ${ exchange.result }<p />
				匯率: ${ exchange.exchange }<p />
				日期: ${ exchange.datetime }<p />
				<button type="button" class="pure-button pure-button-primary" onclick="history.back()">返回</button>
			</fieldset>
		</form>
		<form class="pure-form">
			<fieldset>
				<legend>歷史紀錄</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
				        <tr>
				            <th>id</th>
				            <th>amount</th>
				            <th>from</th>
				            <th>to</th>
				            <th>exchange</th>
				            <th>result</th>
				            <th>datetime</th>
				        </tr>
				    </thead>
				    <tbody>
				    	<% List<Exchange> exchanges = (List<Exchange>)request.getAttribute("exchanges"); %>
				    	<% for(int i=0;i<exchanges.size();i++) {%>
				    		<tr>
				    			<td><%=i+1 %></td>
				    			<td><%=exchanges.get(i).getAmount() %></td>
				    			<td><%=exchanges.get(i).getFrom() %></td>
				    			<td><%=exchanges.get(i).getTo() %></td>
				    			<td><%=exchanges.get(i).getExchange() %></td>
				    			<td><%=exchanges.get(i).getResult() %></td>
				    			<td><%=exchanges.get(i).getDatetime() %></td>
				    		</tr>
				    	<% } %>
				    </tbody>
				</table>
			</fieldset>
		</form>	
	</body>
</html>