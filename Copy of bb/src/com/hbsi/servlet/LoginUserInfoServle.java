package com.hbsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.domain.Usr;

@WebServlet("/LoginUserInfoServle")
public class LoginUserInfoServle extends HttpServlet {
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 response.setContentType("text/html;charset=utf-8");//解决中文字
                   HttpSession session = request.getSession();
                   Usr user = (Usr)session.getAttribute("user");
                   String result=null;
                   if(user == null){
                            result = "您没有登录或已注销!";}
                   else{
result = "您已经登录，用户ID："+ user.getId()+   "用户名："+ user.getUsername()+"<a href='LogoutServlet'>注销</a>";
                   }
            
                   response.setCharacterEncoding("utf-8");
                   response.setContentType("text/html");
                   PrintWriter out =response.getWriter();
                   out.println("<html><body>");
                   out.println(result);
                   out.println("</html></body>");
 
 
         }
 
         /**
          * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
          */
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   // TODO Auto-generated method stub
                   doGet(request, response);
         }
 
}