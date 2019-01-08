<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="SelectGoodServlet" method="post">
            
              <center>按货物编号查询：<input type = "text" name = "goodsID"> </center><br>
              <center>按货物种类查询：<input type = "text" name = "goodsClass"> </center><br>
              <center>按价格查询：<input type="text" name="minNum"> --- <input type="text" name="maxNum"></center><br>
                 <center><input type="submit" value="检索">  </center>
    </form>

</body>
</html>