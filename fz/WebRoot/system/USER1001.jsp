<%@ page import="java.sql.ResultSet"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
ResultSet rs=(ResultSet)request.getAttribute("rsa");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
   if(msg!=""){
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
    <title>用户管理</title>
<link rel="stylesheet" href="<%=basePath%>/css/cjpm.css">
</head>

<SCRIPT LANGUAGE="javaScript">

function got()
{
	location.href="system/USER1002.jsp";
}
 
function del(id)
{
	if(confirm("您确定删除该条数据？")){
	    idFrmMain.hd_login.value=id;
		idFrmMain.action="UserServlet?opt=del";
	    idFrmMain.submit();
	}
}

function gotoUpdate(id){
    //alert(id);
    idFrmMain.hd_login.value=id;
	idFrmMain.action="UserServlet?opt=queryForUpdate";
	idFrmMain.submit();
}
function goSearch(){
    idFrmMain.action="UserServlet?opt=query";
    idFrmMain.submit();
} 

</SCRIPT>
<BODY BACKGROUND="<%=basePath%>/image/bg.gif">
<FORM NAME="idFrmMain" ID="idmig0101" METHOD="POST"  ACTION="" ONSUBMIT="return false" >
<input type="hidden" name="hd_login" >
          <table border=0 cellspacing=0 cellpadding=2 width="100%" bgcolor="gray">
			<tr>
				<td class="headerbar61">用户明细查询</td>
				<td class="headerbar61"><p align="right"><input type=submit value=" 查 询 " onClick="goSearch();"></p></td>
			</tr>
  </table>
			
			<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
			<tr>
				<td></td>
			</tr>
			</table>
		  <table border=0 cellspacing=1 cellpadding=2 width="100%" bgcolor="gray">
			<tr>
				<td class="textbar81" width="15%">用户姓名</td>
				<td class="textbar01" width="35%">
					<input type="text" name="name" size="20">
				</td>
				<td class="textbar81" width="15%">用户登录号</td>
				<td class="textbar01" width="35%"><input type="text" name="login" size="20"></td>
			</tr>
			
			</table>
<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
	<tr>
		<td></td>
	</tr>
</table>
		    <table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="2"  bgcolor="gray">
                <tr>
                    <td class="headerbar61" width="50%" colspan="1">用户明细表</td>
                    <td class="headerbar63" width="50%" colspan="1">
                   <input type="button" name="add" tabindex="1" onClick="javascript:got()" value=" 新 增 "></td>
                </tr>
            </table>

<table border=0 cellspacing=0 cellpadding=2 width="100%" height="5">
	<tr>
		<td></td>
	</tr>
</table>

      	<table border="0" width="100%" id="table1" cellspacing="0"  cellpadding="0"  bgcolor="gray">
        	<tr>
          	<td  width="100%" colspan="1">
          		<table  border="0" cellspacing="1" cellpadding="2" width="100%">
								<tr>
									<td  width="5%" class="headerbar82">序号</td>
									<td  width="35%" class="headerbar82">用户登录号</td>
									<td  width="35%" class="headerbar82">用户姓名</td>
									<td   class="headerbar82">操作</td>
								</tr>
								<%
								if(rs!=null){
								 %>
								<%
								int i=0;
								String strStyle="";
								
								while(rs.next()){
								     i++;
								     if(i%2==0)
								        strStyle="gridbar11";
								     else
								        strStyle="gridbar01";
								
								 %>
								<tr>
									<td  class="<%=strStyle %>" align="center"><%=i %></td>
									<td  class="<%=strStyle %>" align="center"><a href="javascript:gotoUpdate('<%=rs.getString("userLogin") %>')"><%=rs.getString("userLogin") %></a></td>
									<td  class="<%=strStyle %>" align="center"><a href="system/USER1002.jsp"><%=rs.getString("userName") %></a></td>
									<td  class="<%=strStyle %>" align="center">
										<img src="<%=basePath%>/image/del.gif" align="bottom" border="0" alt="删除" onClick="javascript:del('<%=rs.getString("userLogin")%>')" />									</td>
								</tr>
								<%}
								
								 %>
								 <%} %>
			  </table>
			  </td>
					</tr>
				</table>


				<table width="100%" border="0" cellpadding="1" cellspacing="2" >
        	<tr>
          	<td colspan="2" align="right" height="20"  nowrap class="textbar3" >
							&nbsp; 共3条 &nbsp; 第1/1页 &nbsp;      				<a  href="#" style="cursor:hand">首页</a>&nbsp; 
      				<a   style="cursor:hand" href="#">上一页</a>&nbsp;
      				<a  style="cursor:hand" href="#">下一页</a>&nbsp; 
      				<a   style="cursor:hand" href="#">尾页</a>&nbsp; 
							&nbsp;
						</td>
          </tr>
        </table>


</FORM>
</BODY>
</html>
