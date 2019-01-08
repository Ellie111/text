package com.servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
	String msg = "";
	
		 public UserServlet() {	super();}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String state = request.getParameter("q");
	if(state.equals("L")) // 用户登陆
	{
		this.login(request,response);
		}
	else if (state.equals("R")) // 用户注册
		{
		this.register(request,response);
	 }
	 else if (state.equals("M")) //用户修改信息
	 {
	 this.modify(request,response);
	 }
	 else // 其它非法参数
	 {this.doError(request,response);}}
	private void modify(HttpServletRequest request, HttpServletResponse response){
	
	//获取新邮箱，电话号码，用户名
	  String newPhone = request.getParameter("uPhone");
	  String newEmail = request.getParameter("uEmail");
	  String uName = (String) request.getSession().getAttribute("name");
	  //通过用户名查询用户当前信息
	  User user = userDAO.query(uName);
	  // 更改用户信息
	  user.setuEmail(newEmail);
	  user.setuPhone(newPhone);
	  // 将数据存入数据库
	  userDAO.Register(user);
	}
	
	/*
	  * 处理注册的方法 
	  */
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		boolean flag = false;
		System.out.println(request.getParameter("u_name"));
		System.out.println(request.getParameter("u_pass"));
		System.out.println(request.getParameter("rname"));
		System.out.println(request.getParameter("uPhone"));
		System.out.println(request.getParameter("uEmail"));
		System.out.println(request.getParameter("uId"));
	    System.out.println(request.getParameter("gender"));
	
	    // 创建存储用户数据的javaBean
	User user = new User();
	user.setuName((String)request.getParameter("u_name"));
	user.setuPassword((String)request.getParameter("u_pass"));
	user.setuRealName((String)request.getParameter("rname"));
	user.setuSex((String)request.getParameter("gender"));
	user.setuPhone((String)request.getParameter("uPhone"));
	user.setuEmail((String)request.getParameter("uEmail"));
	user.setuID((String)request.getParameter("uId"));
	flag = userDAO.Register(user);
	if (flag)
	{
	msg = "恭喜你，注册成功!";
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	else
{
	msg = "sorry,注册失败，请重新注册!";
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintStream out = new PrintStream(response.getOutputStream());
	out.println("<script>alert('" + msg + "');");
	out.println("window.history.go(-1)</script>");
	}
	}
	/*
	  * 处理登陆的方法
	  */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	// 获取Session对象
	HttpSession session = request.getSession(true);
	// 获取用户输入的用户名及密码
	String uName = request.getParameter("u_name");
String uPass = request.getParameter("u_pass");
	// 验证用户名及密码是否正确
	boolean flag = userDAO.login(uName, uPass);
		if(flag)// 登陆成功
	{
	session.setAttribute("name", uName);
	response.sendRedirect("flights.jsp");
	}
     else // 登陆失败
{
    	 msg = "用户名或密码错误，请核对后重新输入";
    		request.setAttribute("msg", msg);
    		request.getRequestDispatcher("login.jsp").forward(request, response);
}
		}
	private void doError(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.sendRedirect("login.jsp");
	//暂时不实现
	}
	}