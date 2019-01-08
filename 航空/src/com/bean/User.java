package com.bean;

public class User {
	     private String uID;     // 用户身份证号
	     private String uName;     // 用户名
	     private String uPassword;     // 用户密码
	     private String uRealName;     // 用户真实姓名
	     private String uSex;     // 用户性别
	     private String uPhone;     // 用户联系号码
	     private String uEmail;     // 用户邮箱
	     private String tName = "无";     // 旅行社名
	     private String tNo = "0000000000";     // 旅行社营业执照
	     public User()
	     {
	     }
	     /**
	      * 旅行社
	      * @param uID
	      * @param uName
	      * @param uPassword
	      * @param uRealName
	      * @param uSex
	      * @param uPhone
	      * @param uEmail
	      * @param tName
	      * @param tNo
	      */
	     public User(String uID, String uName, String uPassword, String uRealName, String uSex, String uPhone, String uEmail,
	          String tName, String tNo)
	     {
	     this.uID = uID;
	     this.uName = uName;
	     this.uPassword = uPassword;
	     this.uRealName = uRealName;
	     this.uSex = uSex;
	     this.uPhone = uPhone;
	     this.uEmail = uEmail;
	     this.tName = tName;
	     this.tNo = tNo;
	     }
	     /**
	      * 个人乘客
	      * @param uID
	      * @param uName
	      * @param uPassword
	      * @param uRealName
	      * @param uSex
	      * @param uPhone
	      * @param uEmail
	      */
	     public User(String uID, String uName, String uPassword, String uRealName, String uSex, String uPhone, String uEmail)
	     {
	     this.uID = uID;
	     this.uName = uName;
	     this.uPassword = uPassword;
	     this.uRealName = uRealName;
	     this.uSex = uSex;
	     this.uPhone = uPhone;
	     this.uEmail = uEmail;
	     }
	     public String getuID()
	     {
	     return uID;
	     }
	     public void setuID(String uID)
	     {
	     this.uID = uID;
	     }
	     public String getuName()
	     {
	     return uName;
	     }
	     public void setuName(String uName)
	     {
	     this.uName = uName;
	     }
	     public String getuPassword()
	     {
	     return this.uPassword;
	     }
	     
	     public void setuPassword(String uPassword)
	     {
	     this.uPassword = uPassword;
	     }
	     public String getuRealName()
	     {
	     return uRealName;
	     }
	     public void setuRealName(String uRealName)
	     {
	     this.uRealName = uRealName;
	     }
	     public String getuSex()
	     {
	     return uSex;
	     }
	     public void setuSex(String uSex)
	     {
	     this.uSex = uSex;
	     }
	     public String getuPhone()
	     {
	     return uPhone;
	     }
	     public void setuPhone(String uPhone)
	     {
	     this.uPhone = uPhone;
	     }
	     public String getuEmail()
	     {
	     return uEmail;
	     }
	     public void setuEmail(String uEmail)
	     {
	     this.uEmail = uEmail;
	     }
	     public String gettName()
	     {
	     return tName;
	     }
	     public void settName(String tName)
	     {
	     this.tName = tName;
	     }
	     public String gettNo()
	     {
	     return tNo;
	     }
	     public void settNo(String tNo)
	     {
	     this.tNo = tNo;
	     }
	     
	}
