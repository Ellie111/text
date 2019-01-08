<%@page import="com.hzyc.models.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	Object obj = request.getAttribute("dlist") ;
	ArrayList<Department> dlist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px" >
		<tr>
			<td>部门编号</td>
			<td>部门名称</td>
			<td>部门人数</td>
		</tr>
		<%for(int i = 0 ; i < dlist.size() ; i++){
			Department dt = dlist.get(i) ;%>
			<tr>
				<td><%=dt.getDeptCode() %></td>
				<td><%=dt.getDeptName() %></td>
				<td><%=dt.getDepac() %></td>
			</tr>
		<%} %>
	
	</table>



</body>
</html>