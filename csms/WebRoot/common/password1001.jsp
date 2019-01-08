<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=""){
   if(msg!=null){
        out.println("<script type=text/javascript>");
        out.println("alert('"+msg+"')");
        out.println("</script>");
   }
}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线通知</title>
<link rel="stylesheet" href="<%=basePath%>/css/cjpm.css">
<script type="text/javascript" src="../js/page.js"></script>
<script type="text/javascript" src="../js/msn_message.js"></script>
<style type="text/css">
<!--
body {
	background-color: #f8f7f7;
}
-->
</style></head>
<script type="text/javascript">
function save(){
 if(idFrmMain.oldPwd.value==""){
    alert("请填写旧密码");
    return;
    }
 if(idFrmMain.newPwd.value!=""&&idFrmMain.reNewPwd.value!=""){
       if(idFrmMain.newPwd.value!=idFrmMain.reNewPwd.value){
           alert("新密码和确认密码不一致");
           return;
       }
    }
 else{
    alert("新密码和确认密码不能为空");
    return;
 }
 idFrmMain.action="UserServlet?opt=updatePwd";
 idFrmMain.submit();   
}
</script>
<BODY BACKGROUND="<%=basePath%>/image/bg.gif">

<FORM NAME="idFrmMain" ID="BSDTERM001" METHOD="POST"  ACTION="" ONSUBMIT="return false" >
<table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
			<tr>
				<td class="headerbar61"> 修改密码</td>
				<td class="headerbar61"><p align="right"><input type=submit value=" 保 存 " onClick="JavaScript:save();"></p></td>
			</tr>
			</table>
			<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
			</table>
			<table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">
			<tr>
				<td class="textbar81" width="15%">旧密码</td>
				<td class="textbar01" width="85%"><input type="password" name="oldPwd" size="30" ></td>				
			</tr>	
			<tr>
				<td class="textbar81" width="15%">新密码</td>
				<td class="textbar01" width="85%"><input type="password" name="newPwd" size="30" ></td>				
			</tr>	
			<tr>
				<td class="textbar81" width="15%">确认密码</td>
				<td class="textbar01" width="85%"><input type="password" name="reNewPwd" size="30" ></td>				
			</tr>			
			</table>

</FORM>
</body>
</html>


