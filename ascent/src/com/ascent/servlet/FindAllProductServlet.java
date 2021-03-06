package com.ascent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ascent.dao.*;
import com.ascent.bean.*;

@SuppressWarnings("serial")
@WebServlet("/FindAllProductServlet")
public class FindAllProductServlet extends HttpServlet { 
	 public FindAllProductServlet(){
		  super();
		 }
public void init() throws ServletException{
}
public void destroy(){
super.destroy();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");//解决中文字
PrintWriter out=response.getWriter();//创建输出流
ProductDAO dao=new ProductDAO();
List<Product>list=dao.getAllProduct();
request.setAttribute("list",list);
request.getRequestDispatcher("showAllProduct.jsp").forward(request,response); 
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request, response);
}
}