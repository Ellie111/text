<%@page import="com.hzyc.models.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("slist") ;
	ArrayList<Stock> slist = (ArrayList)obj ;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1px" width="100%">
		<tr>
			<td>单据号</td>
			<td>操作类型</td>
			<td>单据类型</td>
			<td>仓库编号</td>
			<td>所属部门</td>
			<td>业务员</td>
			<td>操作员</td>
			<td>时间</td>
			<td>供应商</td>
			<td>客户</td>
			<td>合计金额</td>
			<td>定货单号</td>
			<td>收货单号</td>
			<td>发票号</td>
			<td>发货单号</td>
			<td>备注</td>
		</tr>
		<%for(int i = 0 ; i < slist.size() ; i++){
			Stock st = slist.get(i) ;%>
			<tr>
				<td><%=st.getCode() %></td>
				<td><%=st.getOpeTypeID() %></td>
				<td><%=st.getVouchType() %></td>
				<td><%=st.getWhID() %></td>
				<td><%=st.getDepart() %></td>
				<td><%=st.getClerk() %></td>
				<td><%=st.getOperator() %></td>
				<td><%=st.getOpTime() %></td>
				<td><%=st.getVendor() %></td>
				<td><%=st.getCustomer() %></td>
				<td><%=st.getSumm() %></td>
				<td><%=st.getOrderCode() %></td>
				<td><%=st.getReceiveCode() %></td>
				<td><%=st.getInvoiceCode() %></td>
				<td><%=st.getDispathCode() %></td>
				<td><%=st.getMemo() %></td>
			</tr>
		<%} %>
	</table>
	
	<a href = "kucunmingxi.jsp">填写库存明细</a>



</body>
</html>