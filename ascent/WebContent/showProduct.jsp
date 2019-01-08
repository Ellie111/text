<%@page language="java" import="java.util.*,com.ascent.bean.*"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP' showProduct.jsp starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 
   <link rel="stylesheet" type="text/css" href="style.css">
   -->
<script language="javascript">
function addshop(str){
	var pid=str;
	send_request('./cart?a=add&pid='+pid);
}
var http_request=false;
function send_request(url){
	http_request=false;
	if(window.XMLHttpRequst){
		http_request=new XMLHttpRequst();
		if(http_request.overridMimeType){
			http_request.overridMimeType('text/xml');
		}else if(window.ActiveXObject){
			try{
				http_request=new ActiveXObject("Msxm12.XMLHTTP");
				
			}catch(e){
				try{
					http_request=new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){
				}
			}
		}
		if(!http_request){
			window.alter("不能创建对象实例");
			return false;
		}
		http_request.onreadyststechange=processRequest;
		http_request.open("POST",url,true);
		http_request.send(null);
	}
	function processRequest(){
		if(http_request.readyState==4){
			if(http_request.State==200){
				var divhtml=http_request,responseText;
				alter(divhtml);
			}
		}
	}
}
</script>
</head>
<body>
 <center>
  <h1>商品列表</h1>
  <table cellspacing="1" cellpadding="0" width="90%" border="0">
   <tbody>
    <tr bgcolor="#fba661" height="20">
     <td><div align="center">编号</div></td>
     <td><div align="center">名称</div></td>
     <td><div align="center">药品分类</div></td>
     <td><div align="center">价格</div></td>
     <td><div align="center">图片</div></td>
     <td><div align="center">购买</div></td>
    </tr>
    <c:forEach var="p" items="${allProduct}" >
     <tr bgcolor="#f3f3f3" height="25">
      <td width="10%">
       <div align="center">${p.productnumber}</div>
      </td>
      <td width="13%">
       <div align="center">${p.productname}</div>
	   </td>
      <td width="12%">
       <div align="center">${p.category}</div>
      </td>
      <td width="10%">
       <div align="center">${p.price1}</div>
      </td>
      <td width="12%">
       <div align="center">
        <img height="25" hspace="0"
         src="<%=path%>/images/${p.imagepath}" width="83" border="0"/>
       </div>
      </td>
      <td width="13%">
       <div align="center">
		<button onclick="addshop(${p.id})">购买</button>>
       </div>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </center>
</body>
</html>
 