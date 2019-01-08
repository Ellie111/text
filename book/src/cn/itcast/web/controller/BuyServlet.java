package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;

//完成书籍购买
public class BuyServlet extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     String id = request.getParameter("id");
     BusinessService service = new BusinessService();
     Book book = service.findBook(id);

     // 得到用户的购物车
     Cart cart = (Cart) request.getSession().getAttribute("cart");
     // 用户第一次购买，为用户创建购物车
     if(cart==null) {
         cart = new Cart();
         request.getSession().setAttribute("cart", cart);
     }

     // 把书加到用户的购物车中，完成购买
     cart.add(book);

     /* 
      * 浏览器重新访问地址：/WEB-INF/jsp/listcart.jsp
      * 但这个地址被保护起来，外面是无法直接访问的，
      * 要实现的话，会比较麻烦，需要先跳到servlet，然后再转到jsp。
      */
     // response.sendRedirect("/WEB-INF/jsp/listcart.jsp");

     request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     doGet(request, response);
 }

}