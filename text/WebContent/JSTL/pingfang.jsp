<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平方表</title>
</head>
<body>
 <center>
  <h3>平方表</h3>
    <table border="1">
      <tr>
         <th>value</th>  
         <th>Square</th>
      </tr>
      <c:forEach var="x" begin="0" end="10" step="1"> 
      <tr>         
         <td> <c:out value="${x}"></c:out></td>  
         <td> <c:out value="${x*x}"></c:out></td>   
      </tr>
      </c:forEach>
    </table>
 </center>
</body>
</html>