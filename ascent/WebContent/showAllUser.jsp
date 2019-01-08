<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有用户信息.jstl</title>
</head>
<body><center>
  <table border="1">
<tr>
<td>编号</td><td>用户名</td><td>公司名称</td><td>公司地址</td><td>电话</td><td>电子邮件</td>
	</tr>
	<c:forEach var="user" items="${requestScope.list}">
    <tr>
	 <td><c:out value="${user.id}"/></td>
	 <td><c:out value="${user.username}"/></td>
	 <td><c:out value="${user.companyname}"/></td>
	 <td><c:out value="${user.companyaddress}"/></td>
	 <td><c:out value="${user.tel}"/></td>
 	 <td><c:out value="${user.email}"/></td>
   	</tr>
    </c:forEach>
</table>
</center>
</body>
</html>
