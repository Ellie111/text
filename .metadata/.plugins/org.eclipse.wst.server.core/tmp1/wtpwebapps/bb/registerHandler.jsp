<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.hbsi.domain.Usr,com.hbsi.dao.UserManagerDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册结果</title>
</head>
<body background=i/123.jpg><center >
<jsp:useBean id="user" class="com.hbsi.domain.Usr" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
boolean flag=false;
UserManagerDAO dao =new UserManagerDAO();
flag=dao.Register(user);
if(flag){
    out.print("用户已存在，请重新注册!");
}else{
    out.print("用户注册成功!请点击回到主页或者登录");
}
%>
 <li>
           <h2> <a href="Login.html">主页</span></a> </h2>
        </li>
        <h2><a href="denglu.html">登录</a></h2>
        </center>
</body>
</html>
