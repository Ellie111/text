<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "RukuServlet" method = "post">
	记录号：<input type = "text" name = "autoid"><br>
	货物编号：<input type = "text" name = "goodesid"><br>
	目标仓库：<input type = "text" name = "source"><br>
	计量单位：<input type = "text" name = "unit"><br>
	数量：<input type = "text" name = "quantity"><br>
	入库时间：<input type = "text" name = "opDate"><br>
	操作员：<input type = "text" name = "operator"><br>
	<input type = "submit" value = "登记">
 	</form>

</body>
</html>