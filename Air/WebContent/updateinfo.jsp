<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>个人乘客注册</title>
     <style type="text/css">
          td{
          text-align: left;
          }
     </style>
     <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
     <script type="text/javascript" src="js/jquery.validate.js"></script>
     <script type="text/javascript" src="js/messages_zh.js"></script>
     </head>
     <body>
     <form action="userServlet?q=M" method="post" id="reg" >
          <table align="center" border="1 " width="500" height="400">
          <tr>
               <th colspan="2">用户修改信息</th>
          </tr>
          <tr>
               <td width="20%">用户名:</td>
               <%
            if(session.getAttribute("name") == null)
            {
                    session.setAttribute("msg1", "你还未登陆，请先登陆!");
                    response.sendRedirect("login.jsp");
            }
               %>
               <td><%=session.getAttribute("name")%></td>
          </tr>
          <tr>
               <td>联系电话:</td>
               <td><input type="text" name="uPhone" id="uPhone"></td>
          </tr>
          <tr>
               <td>邮箱:</td>
               <td><input type="text" name="uEmail" id="uEmail"></td>
          </tr>
          <tr >
               <td style="text-align: center;" colspan="2"><input type="submit" value="确认修改">
               </td>
          </tr>
          </table>
     </form>
     </body>
</html>