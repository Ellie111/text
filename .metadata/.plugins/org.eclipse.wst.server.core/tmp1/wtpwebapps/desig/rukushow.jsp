<%@page import="com.hzyc.models.Ruku"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	Object obj = request.getAttribute("dlist") ;
	ArrayList<Ruku> dlist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px">
<tr>
	<td>记录号</td>
	<td>货物编号</td>
	<td>源仓库</td>
	<td>计量单位</td>
	<td>数量</td>
	<td>出库时间</td>
	<td>操作员</td>
</tr>
	<%for(int i = 0 ; i < dlist.size() ; i++){
		Ruku ruku = dlist.get(i) ;%>
		<tr>
			<td><%=ruku.getAutoid() %></td>
			<td><%=ruku.getGoodesid() %></td>
			<td><%=ruku.getSource() %></td>
			<td><%=ruku.getUnit() %></td>
			<td><%=ruku.getQuantity() %></td>
			<td><%=ruku.getOpDate() %></td>
			<td><%=ruku.getOperator() %></td>
		</tr>
	<%} %>

</table>
<a  href = "goodinventory.jsp">货物信息盘点<a/>

</body>
</html>