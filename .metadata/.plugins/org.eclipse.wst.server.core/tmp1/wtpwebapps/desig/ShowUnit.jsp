<%@page import="com.hzyc.models.Unit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("ulist") ;
	ArrayList<Unit> ulist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1px" width = "100%">
		<tr>
			<td>计量单位编号</td>
			<td>计量单位名称</td>
		</tr>
		<%for(int i = 0 ; i < ulist.size() ; i++){
			Unit ut = ulist.get(i) ;%>
			<tr>
				<td><%=ut.getUnitID() %></td>
				<td><%=ut.getUnitName() %></td>
			</tr>
		<%} %>
	</table>



</body>
</html>