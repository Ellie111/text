package com.hbsi.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.domain.Book;
import com.hbsi.service.BusinessService;
import com.hbsi.service.BusinessServiceImpl;


public class KeyServlet extends HttpServlet {
	BusinessService service=new BusinessServiceImpl();
    public KeyServlet() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");//解决中文字体
		response.setContentType("text/html");//设置文件输出类型
		PrintWriter out=response.getWriter();//创建输出流
		String key=request.getParameter("key");//获取用户名
		List<Book> list=service.getAllBookz1(key);
		request.setAttribute("books", list);
		request.getRequestDispatcher("../WEB-INF/jsp/listbook.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
