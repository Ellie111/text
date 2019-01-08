package com.hbsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Book;
import com.hbsi.domain.Cart;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
       

    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    BusinessDAO dao=new BusinessDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");//解决中文字
		//1.获取要买的书
		String sid=request.getParameter("id");
		Book book =dao.findBook(sid);
		//2.得到购物车
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		//3.把数添加到购物车中
		cart.add(book);
		response.sendRedirect("./ListCartServlet");
		//request.getRequestDispatcher("/listcart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
