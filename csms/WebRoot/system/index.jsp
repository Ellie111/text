<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>       
    <title>My JSP 'index.jsp' starting page</title>
	<frameset cols="180,10,*" name="sss" frameborder="NO" border="0" framespacing="0" rows="*">
    <frame name="left" noresize scrolling="auto" src="left.htm">
    <frame src="middle.htm" name="middle" scrolling="NO" noresize>
    <frame name="main" src="../UserServlet?opt=query" scrolling="auto">
   </frameset><noframes></noframes>
<noframes><body>
</body></noframes>
</html>