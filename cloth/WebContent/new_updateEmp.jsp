<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="UpdatePeople" method="post">
      员工号：		<input type="text" name="id" value="${emp.empCode}" readonly="readonly"/> <br />	
      员工名字：		<input type="text" name="name" value="${emp.empName}"><br />	
      员工性别：	 	<input type="text" name="sex" value="${emp.empSex}"><br />	
         密码：		<input type="text" name="password" value="${emp.password}"><br />	
         电话：   		<input type="text" name="tel" value="${emp.empTel}"><br />	
         备注： 	 	<input type="text" name="memo" value="${emp.memo}"><br />	
      在职状态：     	<input type="text" name="state" value="${emp.empState}"><br />		
<input type="submit" value="修改"/>
   <a href="main.jsp">返回</a>
</form>
</body>
</html>