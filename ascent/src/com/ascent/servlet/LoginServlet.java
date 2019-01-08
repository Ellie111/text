package com.ascent.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.bean.Usr;
import com.ascent.dao.LoginDAO;

public class LoginServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;	 
		    public LoginServlet() {
		        super();
		}
		 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=utf-8");//解决中文字
		String username=request.getParameter("username");//获取用户名
		String password=request.getParameter("password");//获取密码
		response.setCharacterEncoding("utf-8");//解决中文字体
		response.setContentType("text/html");//设置文件输出类型
		PrintWriter out=response.getWriter();//创建输出流
		LoginDAO dao = new LoginDAO();
		Usr u = dao.login(username, password);
		System.out.print(u);
		out.println("<html>");
		out.println("<head><title>A Servlet</title></head>");
		out.println("<body>");
		if(u != null){
		HttpSession session=request.getSession();
		session.setAttribute("user", u);
		if("1".equals(u.getSuperuser()))
		   {out.print("您是普通用户，登录成功!信息已保存在会话Session中，请打开userInfo.html查看！");
		out.println("<a href='/ascent/userInfo.html'>用户信息</a>");}
		else
		   out.print("您是管理员用户，登录成功!信息已保存在会话Session中，请打开userInfo.html查看！");
		}
		else
		out.print("用户名或密码错，登录失败！");
		out.println("</body></html>");
		out.flush();
		out.close();
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
		}
