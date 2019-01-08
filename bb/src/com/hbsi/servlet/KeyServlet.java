package com.hbsi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.dao.BookDao;
import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Book;


@WebServlet("/KeyServlet")
public class KeyServlet extends HttpServlet {
	BookDao dao=new BookDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.search(request, response);
		}
	
		private void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=utf-8");//解决中文字
		PrintWriter out=response.getWriter();//创建输出流	
			String s=request.getParameter("style");	
			String st=request.getParameter("key");	
			List<Book> list = new ArrayList<Book>();
			if(s.equals("null")){
				out.println("<center>请先选择搜索方式."+"<a href='/bb/AllBookServlet'>点击此处返回</a></center>");
			}else if(st==""){
				out.println("<center>请先输入你想要搜索的商品信息"+"<a href='/bb/AllBookServlet'>点击此处返回</a></center>");
			}else{
				if(s.equals("name")){//按姓名查询
						this.KeyServlet1(request, response);
					}else if(s.equals("author")){//按作者查询
						this.KeyServlet2(request, response);
				}else if(list.isEmpty()){
out.println("<center>抱歉，未找到您想要的信息。"+"<a href='/bb/AllBookServlet'>点击此处返回</a></center>");
				}
				}	
		}

		private void KeyServlet1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=utf-8");//解决中文字
			PrintWriter out=response.getWriter();//创建输出流
			String key=request.getParameter("key");//获取用户名
			List<Book> list=dao.getAllz1(key);
			request.setAttribute("books", list);
			request.getRequestDispatcher("/listbook.jsp").forward(request, response);
			
		}
		private void KeyServlet2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=utf-8");//解决中文字
			PrintWriter out=response.getWriter();//创建输出流
			String key=request.getParameter("key");//获取用户名
			List<Book> list=dao.getAllz2(key);
			request.setAttribute("books", list);
			request.getRequestDispatcher("/listbook.jsp").forward(request, response);
			
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
