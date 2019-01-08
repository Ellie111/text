<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/zhuce.css" >

</head>
<body>

<div class="index">

			<p class="p1">请输入您的账户和密码，注册成功后会直接跳转到登陆页面</p>

			<hr />
			
			<form action="zhuce" method="post" style="margin-left: 80px; margin-top: 35px;">
				<p>账户：<input type="text" name="name"  placeholder="请输入用户名" /></p>
				<p>密码：<input type="password"  name="password"  placeholder="请输入密码"/></p>
				<input  class="load" type="submit" value="确认提交" /><br>
				
			</form>
		</div>

</body>
</html>