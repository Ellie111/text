<%@page import="com.hzyc.models.Good"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Object obj = request.getAttribute("gList");
	//在jsp中引包不能使用ctrl+shitf+o。把光标放在类的最后侧，按住alt+?自动引包
	ArrayList<Good> gList = (ArrayList)obj;
    //Object safe = application.getAttribute("safe");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<font size = "5">缺货信息提醒：</font><br>
<table border="1px">
		<tr>
			  <td width="50px">货物编号</td>
              <td width="50px">货物名称</td>
              <td width="50px">货物简称</td>
              <td width="50px">货物种类</td>
              <td width="50px">货物规格型号</td>
              <td width="50px">货物单价</td>
              <td width="50px">单位重量</td>
              <td width="50px">单位体积</td>
              <td width="50px">计量单位</td>
              <td width="50px">默认供应商</td>
              <td width="50px">最低库存量</td>
              <td width="50px">最高库存量</td>
              <td width="50px">安全库存</td>
              <td width="50px">仓库编号</td>
              <td width="50px">最高进价</td>
              <td width="50px">最低售价</td>
              <td width="50px">建档人</td>
              <td width="50px">更改人</td>
              <td width="50px">更改时间</td>
              <td width="50px">当前数量</td>
              <td width="50px">上次盘点时间</td>
		</tr>
		
		<%for(int i = 0;i < gList.size();i++){
			Good good = gList.get(i);
			//HashMap<String,String> rsMap = rsList.get(i);
			String now = good.getNowQuantity() ;
			String safe = good.getSafeQuantity();
			String low  = good.getLowQuantity();
			String high = good.getHighQuantity() ;
			if(Integer.parseInt(now) < Integer.parseInt(safe) ){%>
			
			<font color = red><%=good.getGoodsName() %></font>现有数量少于安全库存，处于<font color = red>缺货</font>状态<br>
			
			
		<% 	
		}
		%>
			<tr>
				<td><%=good.getGoodsID() %></td>
				<td><%=good.getGoodsName() %></td>
				<td><%=good.getShortName() %></td>
				<td><%=good.getGoodsClass() %></td>
				<td><%=good.getGoodsStd() %></td>
				<td><%=good.getPrice() %></td>
				<td><%=good.getWeight() %></td>
				<td><%=good.getVolume() %></td>
				<td><%=good.getUnitID() %></td>
				<td><%=good.getVendor() %></td>
				<td><%=good.getLowQuantity() %></td>
				<td><%=good.getHighQuantity() %></td>
				<td><%=good.getSafeQuantity() %></td>
				<td><%=good.getWhID() %></td>
				<td><%=good.getHighPrice() %></td>
				<td><%=good.getLowPrice() %></td>
				<td><%=good.getBuilder()%></td>
				<td><%=good.getModiPerson() %></td>
				<td><%=good.getModiTime()%></td>
				<td><%=good.getNowQuantity() %></td>
				<td><%=good.getLastCleckTime() %></td>
				
				
				
			</tr>
		<% 
		} 
		%>
		
	
	</table>

</body>
</html>