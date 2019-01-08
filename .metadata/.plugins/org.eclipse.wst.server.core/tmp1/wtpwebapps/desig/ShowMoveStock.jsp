<%@page import="com.hzyc.models.MoveStock"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("mlist") ;
	ArrayList<MoveStock> mlist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px" width = "100%">
		<tr>
			<td>记录号</td>
			<td>货物编号</td>
			<td>源仓库</td>
			<td>目的仓库</td>
			<td>计量单位</td>
			<td>数量</td>
			<td>移库时间</td>
			<td>操作员</td>
		</tr>
		<%for(int i = 0 ; i < mlist.size() ; i++){
			MoveStock mt = mlist.get(i) ;%>
			<tr>
				<td><%=mt.getAutoid() %></td>
				<td><%=mt.getGoodesid() %></td>
				<td><%=mt.getSource() %></td>
				<td><%=mt.getTarget() %></td>
				<td><%=mt.getUnit() %></td>
				<td><%=mt.getQuantity() %></td>
				<td><%=mt.getOpDate() %></td>
				<td><%=mt.getOperator() %></td>
			</tr>
	
		<%} %>
	</table>

</body>
</html>