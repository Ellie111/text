package com.hbsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Cart;

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	BusinessDAO dao=new BusinessDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取到购物项
		String sid=request.getParameter("id");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		
		
		dao.deleteCartItem(sid,cart);
		request.getRequestDispatcher("/listcart.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
