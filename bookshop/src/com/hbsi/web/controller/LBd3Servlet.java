package com.hbsi.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.domain.Book;
import com.hbsi.service.BusinessService;
import com.hbsi.service.BusinessServiceImpl;


public class LBd3Servlet extends HttpServlet {
	BusinessService service=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List<Book> list=service.getAllBookd3();
			request.setAttribute("books", list);
			request.getRequestDispatcher("../WEB-INF/jsp/listbook.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
