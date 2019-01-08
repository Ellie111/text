package cn.itcast.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.service.BusinessService;


//获取所有书
public class ListBookServlet extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     BusinessService service = new BusinessService();
     Map<String, Book> map = service.getAllBook();
     request.setAttribute("map", map);

     request.getRequestDispatcher("/WEB-INF/jsp/listbook.jsp").forward(request, response);

 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     doGet(request, response);
 }

}
