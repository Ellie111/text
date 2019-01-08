<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
ResultSet rs=(ResultSet)request.getAttribute("rs"); 
String opt="";
if(rs!=null){
    rs.next(); 
    opt="update";
}
else{
    opt="add";    
}

 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户详细</title>
<link rel="stylesheet" href="<%=basePath%>/css/cjpm.css">
 
</head>

<SCRIPT LANGUAGE="javaScript">

function save()
{
    if(idFrmMain.name.value==""){
         alert("用户名不能为空");
         return;
    }
    if(idFrmMain.login.value==""){
         alert("姓名不能为空");
         return;
    }
    if(idFrmMain.pwd.value==""){
         alert("密码不能为空");
         return;
    }
    if(idFrmMain.note.value==""){
         alert("备注不能为空");
         return;
    }
	idFrmMain.action="UserServlet?opt="+idFrmMain.hd_opt.value;
	idFrmMain.submit();
}

function back()
{
	history.back();
}
  

</SCRIPT>
<BODY BACKGROUND="<%=basePath%>/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0102" METHOD="POST"  ACTION="" ONSUBMIT="return false"> 
<input type="hidden" name="hd_opt" value=<%=opt %> />
<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
	<tr>
  	<td class="headerbar61" width="15%" colspan="1">用户详细</td>
    <td class="headerbar63" width="85%" colspan="1">
      <input type="button" name="save70302002" onClick="javascript:save()" value=" 保 存 ">&nbsp;
      <input type="button" name="back70302003" onClick="javascript:back()" value=" 返 回 ">
    </td>
  </tr>
</table>

<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
	<tr>
		<td></td>
	</tr>
</table>

<table border="0" width="100%" id="table1" cellspacing="1"  cellpadding="2"  bgcolor="gray">
 
	<tr>
  	<td class="textbar81" width="15%" colspan="1">用户登录号</td>
    <td class="textbar01" width="85%" colspan="1"><input name="login" value="<%=rs==null?"":rs.getString("userLogin") %>" size="20"></td>
  </tr>          
  <tr>
  	<td class="textbar81" width="15%" colspan="1">用户姓名</td>
    <td class="textbar01" width="85%" colspan="1"><input name="name" value="<%=rs==null?"":rs.getString("userName") %>" size="20"></td>
  </tr>          
	<tr>
  	<td class="textbar81" width="15%" colspan="1">用户密码</td>
    <td class="textbar01" width="85%" colspan="1"><input type="password" name="pwd" value="<%=rs==null?"":rs.getString("userPwd") %>" size="21"></td>
  </tr>      
	<tr>
  	<td class="textbar81" width="15%" colspan="1">用户简介</td>
    <td class="textbar01" width="85%" colspan="1"><textarea name="note"  style="width:352px"><%=rs==null?"":rs.getString("userNote") %></textarea>
     </td>
  </tr>  
	         
	 
</table>

<table border=0 cellspacing=0 cellpadding=0 width="100%" height=5>
	<tr>
		<td></td>
	</tr>
</table>
</FORM>
</BODY>
</html>


