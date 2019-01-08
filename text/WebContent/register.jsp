<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>

</head>
    <script language="javascript">               //脚本      
   //该函数功能：去掉字符串前后空格
     function  YZ(str){                                   
    return str.replace(/(^\s*)|(\s*$)/g,"");
     }
  
   //该函数功能：检验是否可以注册成功      
     function check(){       
    	 if( YZ(form.id.value)==""){               //无输入或者输入空格键会提示账号不能为空
    	      alert("账号不能为空！");
    	      form.id.focus();
    	      return false;
    	        }
     if( YZ(form.username.value)==""){               //无输入或者输入空格键会提示用户名不能为空
      alert("用户名不能为空！");
      form.username.focus();
      return false;
        }
    if( YZ(form.password.value)==""){                  //无输入会提示输入密码
   alert("请输入密码！");
   form.password.focus();
   return false;
    }
    if( YZ(form.tel.value)==""){                      //无输入会提示输入电话
    alert("请输入电话！");
    form.tel.focus();
    return false;
      }
        var reg =/^(1\d{10})$/;                                  //手机校验，必须以1开头的11位数字
        if((form.tel.value !="" )&&(!form.tel.value.match(reg))){
        alert("电话格式错误！检查后重新输入");
    form.tel.focus();
    return false;
     }
        
    if( YZ(form.email.value)==""){                      //无输入会提示输入邮箱
     alert("请输入邮箱！");
     form.email.focus();
     return false;
      }
     var regm =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;   //邮箱格式校验,开头必须为字母,下划线,数字,
        if((form.email.value !="" )&&(!form.email.value.match(regm))){
         alert("邮箱格式错误！检查后重新输入");
     form.email.focus();
     return false;
        }
        if( YZ(form.companyname.value)==""){              //无输入会提示输入公司名
         alert("请输入公司名！");
         form.companyname.focus();
         return false;
      }       
        if( YZ(form.companyaddress.value)==""){           //无输入会提示输入公司地址
          alert("请输入公司地址！");
          form.companyaddress.focus();
          return false;
       }   
     else
    	// alert("恭喜您，注册成功！");
       return true;
     }
   </script>
<body>
    
  <center><h1>注册页面</h1>
<!--  --><h2>建议您用手机号后4位当做账号，以防账号重复出错！</h2>
   <form name="form" action="registerHandler.jsp" method="get">
    
<table>

<tr>
<td>账号</td>
<td><input type="text" name="id"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>全名：</td> <td><input type="text" name="fullname"></td>
</tr>

<tr>
<td>密码：</td> <td><input type="password" name="password"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>电话：</td> <td><input type="text" name="tel"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>邮箱：</td> <td><input type="text" name="email"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>国家：</td>
<td><input type="text" name="country"></td>
</tr>

<tr>
<td>城市：</td> <td><input type="text" name="city"></td>
</tr>

<tr>
<td>邮编：</td> <td><input type="text" name="zip"></td>
</tr>

<tr>
<td>公司名：</td> <td><input type="text" name="companyname"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>公司地址：</td> <td><input type="text" name="companyaddress"></td>
<td><font color="red">*</font> </td>
</tr>

<tr>
<td>工作：</td> <td><input type="text" name="job"></td>
</tr>

<tr>
<td>职称:</td> <td><input type="text" name="title"></td>
</tr>

<tr>
<td> <input type="submit" value="注册" onclick="return check()"></td>
</tr>
</table>
   
  </form>
 </center>
 
</body>
</html>