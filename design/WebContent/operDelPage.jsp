<%@page import="com.hzyc.models.Operation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("olist") ;
	ArrayList<Operation> olist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action = "DeleteOper" method = "post">
		<select name = "opeTypeID">
		<option>--请选择--</option>
		<%for(int i = 0 ; i < olist.size() ; i++){
			Operation ot = olist.get(i) ; %>
			<option value = "<%=ot.getOpeTypeID() %>"><%=ot.getOpeTypeID() %></option>
			<%}%>
		</select>
		<input type = "submit" value = "删除">
	</form>

</body>
</html>