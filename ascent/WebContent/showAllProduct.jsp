<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path=request.getContextPath()+"/images";
String basePath=request.getScheme()+
"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
/* System.out.println("path:"+path);
System.out.println("basepath:"+basePath); */
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有产品信息.jstl</title>
</head>
<body>
 <center >
  <h1>商品列表</h1>
  <table cellspacing="1" cellpadding="0" width="40%" border="0">
<tbody> <!-- 表体 --> <!-- th:表头 -->
	<tr bgcolor="#fba661" height="20">
	<td><div align="center">编号</div></td>
	<td><div align="center">名称</div></td>
	<td><div align="center">药品分类</div></td>
	<td><div align="center">价格</div></td>
	<td><div align="center">图片</div></td>
	<td><div align="center">购买</div></td>
	</tr>
	<c:forEach var="product" items="${requestScope.list}">
     <tr bgcolor="#f3f3f3" height="25">
	<td width="10%">  <div align="center">
	 <c:out value="${product.productnumber}"/>
	 </td> </div>
	 <td width="13%"><div align="center">
	 <c:out value="${product.productname}"/>
	 </td></div>
	 <td width="10%"><div align="center">
	 <c:out value="${product.category}"/>
	 </td></div>
	 <td width="10%"><div align="center">
	 <td><c:out value="${product.price1}"/>
	 </td></div>
	 <td width="10%"><div align="center">
	  <c:out value="${product.imagepath}"/>
	  </td></div>
	<td width="13%"><div align="center">
    <div align="center"><a href="cart">购买</a></div>
        </td>
   	</tr>
    </c:forEach>
</table>
</center>
</body>
</html>
