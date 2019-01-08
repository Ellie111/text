<%@page import="com.hzyc.models.Operation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Object obj = request.getAttribute("olist") ;
	ArrayList<Operation> olist = (ArrayList)obj ;
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示操作页面</title>
</head>
<body>
	<table border = "1px" >
		<tr>
			<td>操作类型编码</td>
			<td>操作类型名称</td>
		</tr>
		<%for(int i = 0 ; i < olist.size() ; i++){
			Operation ot = olist.get(i) ;%>
			<tr>
				<td><%=ot.getOpeTypeID() %></td>
				<td><%=ot.getOpeTypeNa() %></td>
			</tr>
		<%} %>
	
	</table>

</body>
</html>