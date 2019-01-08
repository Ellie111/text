<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.*,java.sql.*,com.ascent.bean.Usr,com.ascent.dao.UserManagerDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果</title>
</head>
<body>  
      <jsp:useBean id="user" class="com.ascent.bean.Usr" scope="page">
      <jsp:setProperty name="user" property="*"/>    
      </jsp:useBean>
      <% 
UserManagerDAO dao=new UserManagerDAO();
boolean flag=dao.register(user);
if(flag){ 
out.print("用户注册成功，用户信息已经保存在会话session中.<br>下面显示信息取自内置对象session:<br>");
%>       
     用户名：<jsp:getProperty name="user" property="username" />  <br/>
      邮箱: <jsp:getProperty name="user" property="email"/>        
   <% 
}else{
out.print("用户注册失败，请重新注册。可能原因是：该账号已被注册请重新输入您的账号");}%> 
  </body>
</html>