package com.hbsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String sid=request.getParameter("id");//从listbook中获取出来作为信号量
		Book book =dao.findBook(sid);//调用businessdao中的函数
		//2.得到购物车
		HttpSession session=request.getSession();//查看当前请求的会话对象
		Cart cart=(Cart)session.getAttribute("cart");
		//书p201Java servlet回话跟踪API，session中getAttribute取一个cart中的信息（目的地获取）
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		//3.把数添加到购物车中
		cart.add(book);//Cart中的函数
		request.getRequestDispatcher("/listcart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
