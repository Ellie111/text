<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
<script type="text/javascript">
function CheckTel(){
   if(document.form2.TextTel.value==""){
   document.getElementById("king2").innerHTML="手机号不能为空！";
   return false;
     }
var phone= document.form2.TextTel.value;
  var a=/^1[3,4,5,7,8]\d{9}$/;
  var b=a.test(phone);
  if(b){
document.getElementById("king2").innerHTML="";
return true;
}
else{
    document.getElementById("king2").innerHTML="手机号格式错误";
     return false;
   }
   
}
function CheckEmail(){
    if(document.form2.TextEmail.value==""){
          document.getElementById("king3").innerHTML="邮箱不能为空!";
          return false;
          }
    var Email=document.form2.TextEmail.value;
       var a1=/\w{1,}@\w+\.\w{2,3}/
       var b1=a1.test(Email);
       if(b1){
          document.getElementById("king3").innerHTML="";
          return true;
          }
          else{
          document.getElementById("king3").innerHTML="邮箱格式错误!";
           return false;
             }
}
function CheckPwd(){
   var pwd=document.form2.TextPwd.value;
   if(pwd==""){
   document.getElementById("king1").innerHTML="密码不能为空！";
     return false;
   }
   if(pwd.length<6){
      document.getElementById("king1").innerHTML="密码长度不够";
         return false;
      
   }
   document.getElementById("king1").innerHTML="";
     return true;
   
}
function CheckSubmit(){
    return  CheckTel()&&CheckPwd()&&CheckEmail();
}
</script>
</head>
<div>
<center>
</div>
<body >
<div id =  "last" style=" width:100%;float:left" >
  <h1 style="font-size:30px; text-align:left" >注册新用户 <span style="font-size:20px">完成手机/邮箱验证注册，可以获得礼品券哦！</span></h1>
  

 </div> 
<form id="form1" name="form2" method="post" action="registerHandler.jsp" onsubmit="return CheckSubmit()">
  <table >
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