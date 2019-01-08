<%@page import="com.hzyc.models.Warehouse"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("wlist") ;
	ArrayList<Warehouse> wlist = (ArrayList)obj ;
	request.setAttribute("wlist", wlist) ;
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action = "UpdateWHEmpServlet" method = "post">
		请选择变动的仓库：
		<select name = "whID">
		<option>--请选择--</option>
			<%for(int i = 0 ; i < wlist.size() ; i++){
				Warehouse wh = wlist.get(i) ;%>
				
				<option value = "<%=wh.getWhID() %>"><%=wh.getWhID() %></option>
			<%} %>
		</select>
		
		更改后的保管员：<input type = "text" name = "whPerson">
		<input type = "submit" value = "修改">
	</form>

</body>
</html>