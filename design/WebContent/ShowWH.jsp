<%@page import="com.hzyc.models.Warehouse"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("wlist") ;
	ArrayList<Warehouse> wlist = (ArrayList)obj ;

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px"  width = "100%">
		<tr>
			<td>仓库编号</td>
			<td>仓库名称</td>
			<td>仓库管理人</td>
			<td>仓库地址</td>
		</tr>
		<%for(int i = 0 ; i < wlist.size() ; i++){ 
			Warehouse wh = wlist.get(i) ;%>
				<tr>
					<td><%=wh.getWhID() %></td>
					<td><%=wh.getName() %></td>
					<td><%=wh.getWhPerson() %></td>
					<td><%=wh.getWhAddr() %></td>
				</tr>
		<%} %>
	
	</table>



</body>
</html>