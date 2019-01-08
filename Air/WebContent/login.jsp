<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
     <script type="text/javascript" src="js/jquery-1.11.0.min.js" ></script>
     <script type="text/javascript" src="js/jquery.validate.js" ></script>
     <script type="text/javascript" src="js/messages_zh.js" ></script>
     <script>
          $(function(){
          $("form").validate({
               rules: {
               u_name:"required",
               u_pass:"required",
               },
               messages: {
               u_name: "请输入用户名!",
               u_pass: "请输入密码!",
               },
          });
          })
          <%
          
          if(request.getAttribute("msg") != null)
               out.println("alert('" + session.getAttribute("msg") +"')");
          if(session.getAttribute("msg1") != null)
               out.println("alert('" + session.getAttribute("msg1") +"')");
          %>
     </script>
     </head>
     <body>
     <form action="UserServlet?q=L" method="post" id="f">
          <table border="1" width="500px" height="100px" align="center">
          <tr>
               <th bgcolor="#8F8F94" colspan="2">用户登陆</th>
          </tr>
          <tr>
               <td width="30%" align="right">
               用户名:
               </td>
               <td>
               <input type="text" name="u_name" />
               </td>
          </tr>
          <tr>
               <td align="right">
               密码:
               </td>
               <td>
               <input type="password" name="u_pass" />
               </td>
          </tr>
          <tr>
               <td colspan="2" align="center">
               <input type="submit" value="登陆"/>
               <input type="reset" value="重置" />
               </td>
          </tr>
          </table>
     </form>
     </body>
</html>