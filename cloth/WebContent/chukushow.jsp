<%@page import="com.hzyc.servlet.Chuku"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	Object obj = request.getAttribute("dlist") ;
	ArrayList<Chuku> dlist = (ArrayList)obj ;
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
		Chuku chuku = dlist.get(i) ;%>
		<tr>
			<td><%=chuku.getAutoid() %></td>
			<td><%=chuku.getGoodesid() %></td>
			<td><%=chuku.getSource() %></td>
			<td><%=chuku.getUnit() %></td>
			<td><%=chuku.getQuantity() %></td>
			<td><%=chuku.getOpDate() %></td>
			<td><%=chuku.getOperator() %></td>
		</tr>
	<%} %>

</table>
<a  href = "goodinventory.jsp">货物信息盘点<a/>

</body>
</html>