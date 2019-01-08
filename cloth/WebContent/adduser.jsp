<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adduser.css" >
</head>
<body>
<div class = "adduser">
   <form action="Addemp" method="post">
 	
 
 
   <table>
     <tr>
         <td>员工编号：</td>
         <td><input type="text" name="empCode"> </td>
     </tr>
      <tr>
         <td>员工姓名：</td>
         <td><input type="text" name="empName"></td>
     </tr>
      <tr>
         <td>性  别：   </td>
         <td> <input type="text" name="empSex" ></td>
			 
     </tr>
      <tr>
         <td>密码：</td>
         <td><input type="text" name="password"></td>
     </tr>
      <tr>
         <td>联系方式：</td>
         <td><input type="text" name="empTel"></td>
     </tr>
     <tr>
         <td>备注信息：</td>
         <td><input type="text" name="memo"></td>
     </tr>
      <tr>
         <td>在职状态：</td>
         <td><input type="text"  name="state"></td>
        
     </tr>
   </table>
   <center><input type="submit" value="添加"> </center>
  </form>
  </div>
</body>
</html>