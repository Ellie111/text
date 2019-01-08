<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>书店</title>
    <script  language="javascript" type="text/javascript">
function checkField(val)//定义触发方法
{
	window.location.href="/bb/ListBookServlet?select="+val;//传递信号值，用来到servlet中调用不同的函数
	
}

</script>
  </head>
  <body style="text-align:center" background=i/a.jpg>
    <h2>书店</h2>
  <form action="KeyServlet" role="search"> 
  选择搜索方式：
  <select name="style">
              <option value="null">  </option>
              <option value="name">书名</option>
              <option value="author">作者</option>
            </select>
 <tr>
 
<input type="text" name="key"  placeholder="请先选择搜索方式">
 <input type="submit" value="查询" onclickm="return search()" />
  </form>
      </tr>
      <table border="1" width="80%">
        <tr>
           <td><input name="Submit" type="button" value="全部商品" onClick="window.location.reload('AllBookServlet');" ></td>
           <td>书名</td>
           <td>作者</td>
            <td>
            <select name="select" onchange="checkField(this.value)" >
              <option selected="selected"value="value">价格</option>
              <option value="1"> 从高到底排序
              </option>
              <option value="2">从低到高排序</option>
            </select>
            </td>
           <td><select name="select" onchange="checkField(this.value)">
              <option selected="selected"value="value">主分类</option>
              <option value="3"> 科学技术</option>
              <option value="4">文学艺术</option>
              <option value="5"> 生活 </option>
              <option value="6"> 教育 </option>
            </select></td>
           <td><select name="select" onchange="checkField(this.value)">
              <option selected="selected"value="value">次分类</option>
              <option value="7"> 文学
              </option>
              <option value="8">小说</option>
            </select></td>
           <td>销量</td>
           <td>操作</td>   
        </tr>
        <c:forEach var="book" items="${books}">
          <tr>
          <td>${book.id}</td>
           <td>${book.name}</td>
           <td>${book.author}</td>
           <td>${book.price}</td>
           <td>${book.description}</td>
           <td>${book.category}</td>
           <td>${book.sales}</td>
           <td>
    <a href="/bb/BuyServlet?id=${book.id}">购买</a>
           </td>   
          </tr>
        </c:forEach>
      </table>
     
  </body>
</html>
