package com.ascent.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ascent.bean.Usr;
import com.ascent.dao.UserManagerDAO;
@SuppressWarnings("serial")

@WebServlet("/FindAlluserServlet")
public class FindAlluserServlet extends HttpServlet{
 
 public FindAlluserServlet(){
  super();
 }
 

 public void init()throws ServletException{

 }
 public void destroy(){
//  super.destroy();
 }
 
 public void doGet(HttpServletRequest request,HttpServletResponse response)
 throws ServletException,IOException{
  response.setContentType("text/html;charset=utf-8");
  PrintWriter out = response.getWriter();
  out.println("<!DOCTYPE HTML>");
  out.println("<html>");
  out.println("<head><title>A servlet</title></head>");
  out.println("<body><center><table border=1>");
  out.println("<tr><td>编号</td><td>用户名</td><td>公司名称</td><td>公司地址</td><td>电话</td><td>电子邮件</td></tr>");
  UserManagerDAO dao = new UserManagerDAO();
  List<Usr> users = dao.getAllProductUser();
  for(Usr u:users){
   out.println("<tr><td>"+u.getId()+"</td><td>"+u.getUsername()+"</td><td>"+u.getCompanyname()+"</td><td>"+u.getCompanyaddress()+
     "</td><td>"+u.getTel()+"</td><td>"+u.getEmail()+"</td></tr>");
  }
  out.println("<table></center></body>");
  out.println("<html>");
  out.flush();
  out.close();
  }
 
 public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
  this.doGet(request, response);
 }
 
}
