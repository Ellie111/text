<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
</head>
<div>
<center>
</div>
<form  id="form1" name="form2" action="UserServlet?q=R" method="post" onsubmit="return CheckSubmit()">
  <table >
  <tr>
      <td >身份证:</td>
      <td >
      <input type="text" name="uId"/>
      </td>
    </tr>
  <tr>
      <td >用户名:</td>
      <td >
      <input type="text" name="u_name"/>
      </td>
    </tr>
    <tr>
      <td>密码:</td>
      <td >
      <input name="u_pass" type="password" id="TextPwd" onblur="CheckPwd()"/>
      </td>
      <td><span id="king1">&nbsp;</span></td>
    </tr>
    <tr>
      <td >真实姓名:</td>
      <td >
      <input type="text" name="rname"/>
      </td>
    </tr>
     <tr>
      <td >性别:</td>
      <td >
      <input type="text" name="uSex"/>
      </td>
    </tr>
    <tr>
      <td >手机号:</td>
      <td >
      <input name="uPhone" type="text" id="TextTel"onblur="CheckTel()" />
      </td>
      <td ><span id="king2">&nbsp;</span></td>
    </tr>
     <tr>
      <td >邮箱:</td>
      <td >
      <input name="uEmail" type="text" id="TextEmail"onblur="CheckEmail()" />
      </td>
      <td ><span id="king3">&nbsp;</span></td>
    </tr>
    
  </table>
   <input type="submit"  value="立即注册">
</form>
</center>
</body></html>