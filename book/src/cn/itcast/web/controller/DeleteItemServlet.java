package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;

public class DeleteItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        BusinessService service = new BusinessService();
        service.deleteCartItem(id, cart);

        // 删除成功，还是跳转到listcart.jsp页面
        request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
