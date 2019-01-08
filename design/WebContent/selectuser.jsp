<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adduser.css" >
</head>
<body>

<div class = "adduser">
	<form action="SelectEmp" method="post">
             <!--  按员工编号检索：<input type="text" name="minNum"> --- <input type="text" name="maxNum"><br >
                       
              按员工姓名检索：<input type = "text" name = "name"> </input>
                 -->
                
                <table>
                
              	 <tr>
                        <td> 按员工编号检索：</td>
                        <td><input type="text" name="minNum"> --- <input type="text" name="maxNum"></td>
	           </tr>
                
                
                
              	 <tr>
                        <td>   按员工姓名检索：</td>
                        <td><input type = "text" name = "name"> </input></td>
	           </tr>
            
                </table>
                
                 <center> <input type="submit" value="检索"></center>
                
    </form>
</div>
</body>
</html>