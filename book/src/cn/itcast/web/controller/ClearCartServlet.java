package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;

public class ClearCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        BusinessService service = new BusinessService();
        service.clearCart(cart);

        request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}