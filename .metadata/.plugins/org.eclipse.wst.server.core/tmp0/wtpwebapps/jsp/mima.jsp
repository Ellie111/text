<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mima.jsp</title>
</head>
<body>
<table border="1">
<tr>
<td>username</td>
<td><% String username=request.getParameter("username"); %>
<%=username %></td>
</tr>
<tr>
<td>password</td>
<td><% String password=request.getParameter("password"); %>
<%=password %></td>
</tr>
</table>
</body>
</html>