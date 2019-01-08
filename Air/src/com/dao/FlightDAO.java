package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Flight;

import tools.DBManager;

public class FlightDAO {
	
	     /*// 测试
	     public static void main(String[] args)
	     {
	     FlightDAO flightDao = new FlightDAO();
	     List<Flight> flights = flightDao.search("北京", "上海", "2017-05-25");
	     for (Flight f : flights)
	     {
	          System.out.print(f.getfName() + "\t");
	     }
	     }*/
	

	public List<Flight> search(String startCity, String endCity, String date) {
		List<Flight> flightList = new ArrayList<>();     //用于存储航班信息的List
	     // 从数据库中获取航班信息
	     String sql = "select * from flight_info where start_city like '" 
	          + startCity + "' and end_city like '" + endCity + "' and start_time like '"
	          + date + "%'"; //查询所用的sql语句
	     try(ResultSet rs = DBManager.select(sql))
	     {
	          while (rs.next())
	          {
	          Flight f = new Flight();
	          f.setfNo(rs.getString(1));
	          f.setfName(rs.getString(2));
	          f.setPlaneType(rs.getString(3));
	          f.setStartTime(rs.getString(4));
	          f.setEndTime(rs.getString(5));
	          f.setStartCity(rs.getString(6));
	          f.setEndCity(rs.getString(7));
	          f.setEcoTicket(new Integer(rs.getInt(8)).toString());
	          f.setEcoTicketPrice(new Double(rs.getDouble(9)).toString());
	          f.setVIPTicket(new Integer(rs.getInt(10)).toString());
	          f.setVIPTicketPrice(new Double(rs.getDouble(11)).toString());
	          flightList.add(f);
	          }
	     } catch (SQLException e)
	     {
	          System.out.println("从数据库中读取航班信息时出错...");
	          e.printStackTrace();
	     }
	     
	     return flightList;
	}
}
