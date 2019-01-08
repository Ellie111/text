<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action = "SelectOper" method = "post">
		请选择查询类型：
		<input type = "radio" name = "choose" value = "opeTypeID">编号
		<input type = "radio" name = "choose" value = "opeTypeNa">名称
		请输入查询的值：
		<input type = "text" name = "needvalue">
		<input type = "submit" value = "查询" >
	</form>

</body>
</html>