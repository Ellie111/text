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
<form action = "DeleteDep" method = "post">
		<select name = "deptCode">
		<option>--请选择--</option>
		<%for(int i = 0 ; i < dlist.size() ; i++){
			Department dt = dlist.get(i) ; %>
			<option value = "<%=dt.getDeptCode() %>"><%=dt.getDeptCode() %></option>
			<%}%>
		</select>
		<input type = "submit" value = "删除">
	</form>

</body>
</html>