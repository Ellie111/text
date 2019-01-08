<%@page import="com.hzyc.models.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("gList");
	//在jsp中引包不能使用ctrl+shitf+o。把光标放在类的最后侧，按住alt+?自动引包
	ArrayList<Emp> gList = (ArrayList)obj;

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px" width = "100%">
		<tr>
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>员工性别</td>
			<td>密  码</td>
			<td>员工电话</td>
			<td>备  注</td>
			<td>在职状态</td>
		</tr>
		
		<%for(int i = 0;i < gList.size();i++){
			Emp emp  = gList.get(i);
			//HashMap<String,String> rsMap = rsList.get(i);
		%>
			<tr>
				<td><%=emp.getEmpCode() %></td>
				<td><%=emp.getEmpName() %></td>
				<td><%=emp.getEmpSex() %></td>
				<td><%=emp.getPassword()%></td>
				<td><%=emp.getEmpTel() %></td>
				<td><%=emp.getMemo()%></td>
				<td><%=emp.getEmpState()%></td>
			</tr>
		<% 
		} 
		%>
		
	
	</table>



</body>
</html>