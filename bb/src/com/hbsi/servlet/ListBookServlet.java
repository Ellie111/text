package com.hbsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.dao.BookDao;
import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Book;

@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
    public ListBookServlet() {
    }
    BookDao dao=new BookDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//解决中文字
		String state=request.getParameter("select");	
	 if(state.equals("1")){//价格从高到低
			this.ListBookServletp(request, response);
		}else if(state.equals("2")){//价格从低到高
			this.ListBookServletp1(request, response);
	}else if(state.equals("3")){//分类一：科学技术
		this.ListBookServletd1(request, response);
	}else if(state.equals("4")){
		this.ListBookServletd2(request, response);
	}else 
		if(state.equals("6")){
		this.ListBookServletd3(request, response);
	}else if(state.equals("5")){
		this.ListBookServletd4(request, response);
	}else
		if(state.equals("7")){
		this.ListBookServletc1(request, response);
	}else if(state.equals("8")){
		this.ListBookServletc2(request, response);
		}
	}


	private void ListBookServletc2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAllc2();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
	
	}


	private void ListBookServletc1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAllc1();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);	
		
	}


	private void ListBookServletd4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAlld4();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}


	private void ListBookServletd3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAlld3();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}


	private void ListBookServletd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAlld2();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}


	private void ListBookServletd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAlld1();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}
	private void ListBookServletp1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAllp1();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}


	private void ListBookServletp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list=dao.getAllp();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
}
