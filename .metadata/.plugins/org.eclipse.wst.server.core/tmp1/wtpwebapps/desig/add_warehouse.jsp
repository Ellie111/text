<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

   <form action = "AddWHServlet" method = "post" >
		<center>仓库编号：<input type = "text" name = "whID"></center><br>
		<center>仓库名：<input type = "text" name = "Name"></center><br>
		<center>负责人：<input type = "text" name = "whPerson"></center><br>
		<center>仓库地址：<input type = "text" name = "whAddr"></center><br>
			<center><input type = "submit" value = "添加"></center>
	</form>

</body>
</html>