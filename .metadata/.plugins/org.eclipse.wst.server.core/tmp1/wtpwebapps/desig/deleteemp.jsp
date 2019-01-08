<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adduser.css" >
</head>
<body>
<div class = "adduser">
<form  action = "DeleteEmpServlet" method = "post">

输入您想要删除的员工编号<input style = "text" name = "empCode"></input><br>
输入您想要删除的员工姓名<input style = "text" name = "empName"></input><br>
                       <input type = "submit" value = "提交">


</form>
</div>
</body>
</html>