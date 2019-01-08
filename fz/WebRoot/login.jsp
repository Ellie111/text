<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String msg=(String)request.getAttribute("msg");
 if(msg!=null){
    out.println("<script type='text/javascript'>");
    out.println("alert('"+msg+"');");
    out.println("</script>");
 }
%>
<script type="text/javascript">
function  doLogin(){
 if(idFrmMain.userLogin.value==""){
 alert("请输入用户名");
 return;
 }
 if(idFrmMain.userPwd.value==""){
 alert("请输入密码");
 return;
 }
 idFrmMain.action="UserServlet?opt=login";
 idFrmMain.opt.value="login";
 idFrmMain.submit();
}
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <TITLE>服装库存管理系统</TITLE>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
    <link rel="stylesheet" type="text/css" href="css/frame.css">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <BODY  BACKGROUND="image/bg.gif">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td width="100%" height="32"><TABLE WIDTH=100% BORDER=0 CELLPADDING=0 CELLSPACING=0>
            <TR>
              <TD width="376"> <IMG SRC="image/top_1.jpg" WIDTH=376 HEIGHT=54 ALT=""></TD>
              <TD width="90%" align="right" valign="bottom" background="image/top_2.jpg"><table width="100%"  border="0" align="right" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="5%" align="center">&nbsp;</td>
                    <td width="80%" align="right">&nbsp;</td>
                    <td width="27%" align="right"><table width="75%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="128" height="24" align="right" ></td>
                        </tr>
                    </table></td>
                  </tr>
              </table></TD>
            </TR>
          </TABLE></td>
		</tr>
 
</table>

<FORM NAME="idFrmMain"   METHOD="POST"  ACTION="Main.htm"   >
<input type="hidden" name="opt">
<table   width="100%" height="40%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="middle">
			  <table width="300"  border="0" cellspacing="0" cellpadding="0">
              <tr>
			      <td>用户名:<input name="userLogin" type="text" size="10">
                  </td>
                <td>&nbsp;密码:<input name="userPwd" type="password" size="10"></td>
              
              <td width="42"><input name="imageField" type="button" onclick="doLogin();" value="登录" alt="登录" width="42" height="32" border="0"  ></td>
            </tr>
        </table></td>
  </tr>
</table>
</form>

</BODY>
</html>
