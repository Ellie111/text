<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adduser.css" >
</head>
<body>


<form action="AddgoodServlet" method="post">

 	<center>货物编号：<input type="text" name="goodsID"></center>
	<center>货物名称：<input type="text" name="goodsName"></center>
	<center>货物简称：<input type="text" name="shortName"></center>
	<center>货物种类：<input type="text" name="goodsClass"></center>
	<center>货物规格型号：<input type="text" name="goodsStd"></center>
	<center>货物单价：<input type="text" name="price"></center>
	<center>单位重量：<input type="text" name="weight"></center>
	<center>单位体积：<input type="text" name="volume"></center>
	<center>计量单位 ：<input type="text" name="unitID"></center>
	<center>默认供应商：<input type="text" name="vendor"></center>
	<center>最低库存量：<input type="text" name="lowQuantity"></center>
	<center>最高库存量：<input type="text" name="highQuantity"></center>
	<center>安全库存：<input type="text" name="safeQuantity"></center>
	<center>仓库编号：<input type="text" name="whID"></center>
	<center>最高进价：<input type="text" name="highPrice"></center>
	<center>最低进价：<input type="text" name="lowPrice"></center>
	<center>建档人：<input type="text" name="builder"></center>
	<center>更改人：<input type="text" name="modiPerson"></center>
	<center>更改时间：<input type="date" name="modiTime"></center>
	<center>当前数量：<input type="text" name="nowQuantity"></center>
	<center>上次盘点时间：<input type="date" name="lastCleckTime"></center><br>
	

<center><input type="submit" value="添加"/></center>



</form>

</body>
</html>