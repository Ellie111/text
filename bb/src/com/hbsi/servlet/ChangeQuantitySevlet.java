package com.hbsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hbsi.dao.BusinessDAO;
import com.hbsi.domain.Cart;

@WebServlet("/ChangeQuantitySevlet")
public class ChangeQuantitySevlet extends HttpServlet {
       
    public ChangeQuantitySevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");//解决中文字
		String sid = request.getParameter("id");
		String quantity = request.getParameter("quantity");
		HttpSession session=request.getSession();//查看当前请求的会话对象
		Cart cart=(Cart)session.getAttribute("cart");
		//书p201Java servlet回话跟踪API，session中getAttribute取一个cart中的信息（目的地获取）
		BusinessDAO dao=new BusinessDAO();
		dao.changeQuantity(sid,quantity,cart);
		request.getRequestDispatcher("/listcart.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
