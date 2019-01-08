<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%Object username1 = session.getAttribute("username1");
 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style = "background-color : cornflowerblue">
<font  style= "font-size:20px;font-family:微软雅黑;"> 欢迎使用仓库管理系统</font>


<font style = "font-size:20px;font-family:微软雅黑;margin-left: 480px;">当前用户为：<%=username1 %></font>

<a href = "zhuce.jsp"style="float:right;font-size:20px;font-family:微软雅黑;" target="_blank">注册新用户</a>
<a href = "login.jsp"style="float:right; margin-right:10px;font-size:20px;font-family:微软雅黑;" target="_blank">切换用户</a>


</body>
</html>