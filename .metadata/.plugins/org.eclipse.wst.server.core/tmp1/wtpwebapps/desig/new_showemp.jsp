<%@page import="java.util.List"%>
<%@page import="com.hzyc.models.Emp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
Emp emp = new Emp();
List<Emp> aList = emp.query();
request.setAttribute("aList", aList);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border="1px" width="100%">
		<tr>	
			  <td >员工号</td>
              <td >员工姓名</td>
              <td >性别</td>
              <td >密码</td>
              <td >联系方式</td>
              <td >备注</td>
              <td >在职状态</td>
		</tr>
		
		<c:forEach items="${aList}" var="emp">
			<tr>
				
				<td>${emp.empCode}</td>
				<td>${emp.empName}</td>
				<td>${emp.empSex}</td>
				<td>${emp.password}</td>
				<td>${emp.empTel}</td>
				<td>${emp.memo}</td>
				<td>${emp.empState}</td>
				<td>
					<a href="NewselcetByempCode?empCode=${emp.empCode}" target="_blank">修改</a>
			
				</td>
			
			</tr>
		</c:forEach>
	
	</table>



</body>
</html>