<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.*,java.sql.*,com.hbsi.domain.Usr,com.hbsi.dao.UserManagerDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果</title>
</head>
<body>
<jsp:useBean id="user" class="com.hbsi.domain.Usr" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
boolean flag=false;
UserManagerDAO dao =new UserManagerDAO();
flag=dao.Register(user);
if(flag){
    out.print("用户已存在，请重新注册!");
}else{
    out.print("用户注册成功!信息为->");
    Usr p=(Usr)session.getAttribute("user");
    out.print("用户名:"+p.getUsername()+' '+"Email:"+p.getEmail());
}
%>
 <li>
            MAIN<br />
            <a href="Login.html">主页</span></a>
        </li>
</body>
</html>
