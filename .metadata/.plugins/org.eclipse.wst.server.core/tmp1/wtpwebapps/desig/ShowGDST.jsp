<%@page import="com.hzyc.models.Good"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	Object obj = request.getAttribute("glist") ;
	ArrayList<Good> glist = (ArrayList)obj ;

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1px" width = "100%">
		<tr>
			<td>货物编号</td>
			<td>仓库编号</td>
			<td>数量</td>
		</tr>
		<%for(int i = 0 ; i < glist.size() ; i++){
			Good goods = glist.get(i) ;%>
			<tr>
				<td><%=goods.getGoodsID() %></td>
				<td><%=goods.getWhID() %></td>
				<td><%=goods.getNowQuantity() %></td>
			</tr>
			
		<%} %>
		</table>



</body>
</html>