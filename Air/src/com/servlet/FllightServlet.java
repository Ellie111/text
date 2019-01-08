package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.dao.FlightDAO;

@WebServlet("/FllightServlet")
public class FllightServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     
	  /**
	       * @see HttpServlet#HttpServlet()
	       */
	  public FllightServlet() {
	            super();
	            // TODO Auto-generated constructor stub
	  }
	     /**
	      * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	      */
	     protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     //从客户端获取输入
	     String startCity = request.getParameter("start_city");
	     String endCity = request.getParameter("end_city");
	     String date = request.getParameter("date");
	     System.out.println("出发城市:" + startCity + "\t到达城市:" + endCity + "\t出发时间：" + date);
	     FlightDAO flightDao = new FlightDAO();
	     List<Flight> flights = flightDao.search(startCity, endCity, date);     //从数据库中获取符合条件的航班信息
	     System.out.println(flights.isEmpty());
	     for(Flight f : flights)
	     {
	          System.out.println(f.getfName());
	     }
	     // 如果航班信息不为空将航班信息存入Session中
	     if(!flights.isEmpty())
	          request.setAttribute("flights", flights);
	     if(flights.isEmpty())
	          request.setAttribute("mess", "对不起!没有您所需要的航班!");
	     // 定位到航班信息显示页面
	     request.getRequestDispatcher("flights.jsp").forward(request, response);
	     }
	}