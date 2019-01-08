<%@page import="com.hzyc.models.Kuncunmingxi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("slist") ;
	ArrayList<Kuncunmingxi> slist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px" width="100%">
		<tr>
			<td>单据号</td>
			<td>货物编号</td>
			<td>计量单位</td>
			<td>货物单价</td>
			<td>货物数量</td>
			
		</tr>
		<%for(int i = 0 ; i < slist.size() ; i++){
			Kuncunmingxi kuncun = slist.get(i) ;%>
			<tr>
				<td><%=kuncun.getCode() %></td>
				<td><%=kuncun.getGoodsID() %></td>
				<td><%=kuncun.getUnit() %></td>
				<td><%=kuncun.getPrice() %></td>
				<td><%=kuncun.getQuantity() %></td>
				
			</tr>
		<%} %>
	</table>



</body>
</html>