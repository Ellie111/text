<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/manager.css" >
</head>
<body>


 <div class="index">
			<p class="p1">请提供管理员权限</p>

			<hr />
			<form action="Manager" method="post" style="margin-left: 80px; margin-top: 35px;">
				<p>账户：<input type="text" name="name" value="" placeholder="请输入管理员账号" /></p>
				<p>密码：<input type="password"  name="password" value=""  placeholder="请输入管理员密码"/></p>
				<input  class="load" type="submit" value="登录" /><br>
				<!-- <input  class="load" type="submit" value="注册"  href = "zhuce.jsp" /> -->
				 
			</form>
		</div>

</body>
</html>