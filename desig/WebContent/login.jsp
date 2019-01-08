<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link rel="stylesheet" href="css/index.css" >
</head>
<body>
  
  <div class="index">
			<p class="p1">仓库管理系统</p>

			<hr />
			<form action="login" method="post" style="margin-left: 80px; margin-top: 35px;">
				<p>账户：<input type="text" name="name" value="" placeholder="请输入用户名" /></p>
				<p>密码：<input type="password"  name="password" value=""  placeholder="请输入密码"/></p>
				<input  class="load" type="submit" value="登录" /><br>
				<!-- <input  class="load" type="submit" value="注册"  href = "zhuce.jsp" /> -->
				<input  class="load" type="button"  value="注册" onclick='location.href=("zhuce.jsp")' />
			</form>
		</div>
</body>
</html>