package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
         	response.setContentType("text/html;charset=utf-8");//解决中文字
             String name =request.getParameter("u_name");
             String pwd =request.getParameter("u_pass");
             boolean flag = dao.login(name, pwd);
             HttpSession session =request.getSession();
             PrintWriter out = response.getWriter();
             String msg=null;
             if(flag)// 登陆成功
         	{
         	session.setAttribute("u_name", name);
         	response.sendRedirect("flights.jsp");
         	}
              else // 登陆失败
         {
             	 msg = "用户名或密码错误，请核对后重新输入";
             		request.setAttribute("msg", msg);
             		request.getRequestDispatcher("login.jsp").forward(request, response);
         }
             }
         		
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             // TODO Auto-generated method stub
             doGet(request, response);
   }

}