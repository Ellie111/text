package com.hbsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Book;


@WebServlet("/AllBookServlet")
public class AllBookServlet extends HttpServlet {
	BusinessDAO dao=new BusinessDAO();
    public AllBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//解决中文字
		List<Book> list=dao.getAllBook();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/listbook.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
