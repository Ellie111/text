package com.hbsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.dao.LoginDAO;
import com.hbsi.domain.Usr;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 
	    public LoginServlet() {
	        // TODO Auto-generated constructor stub
	    }
	         
	         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                   LoginDAO dao = new LoginDAO();
	               	response.setContentType("text/html;charset=utf-8");//解决中文字
	                   String name =request.getParameter("username");
	                   String pwd =request.getParameter("password");
	                   Usr user = dao.LogIn(name, pwd);
	                   HttpSession session =request.getSession();
	                   PrintWriter out = response.getWriter();
	                   String msg=null;
	                   if(user!=null){
	                   session.setAttribute("user", user);
	                   msg="欢迎您~登录成功，请打开\n"+"<a href='AllBookServlet'>游览书籍信息</a>"+"进行购买!"
	                		  +   "如要退出点击\n"+"<a href='userInfo.html'>注销</a>\n"+"进行注销操作";
	                   }
	                   else{
	                   msg="用户名或密码错，登录失败，返回重新登录或点击"+"<a href='register.jsp'>注册页面</a>"+"进行用户注册!";}
	                   out.println("<html><body background=i/123.jpg><h2><center>");
	                   out.println(msg);
	                   out.println("</center></h2></html></body>");
	         }
	         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                   // TODO Auto-generated method stub
	                   doGet(request, response);
	         }
	 
	}