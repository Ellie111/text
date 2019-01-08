package com.flight.dao;

import java.util.List;

import com.flight.bean.Admin;
import com.flight.bean.Flight;
import com.flight.bean.Order;
import com.flight.bean.Personal;
import com.flight.bean.Travel;

public interface DBOperation {
	    Admin getAdmin(String username);
	    Personal getPersonal(String username);
	    Travel getTravel(String username);
	    Order getOrder(String name);
	    
	    Flight getFlight_ID(String flightID);
	    Flight getFlight_Place(String flightplace,String arriveplace);
	    Flight getFlight_Time(String flightID);
	    List<Flight> getFlight_ALL();
	    List<Flight> getFlightID(String flightID);

	    void addPersonal(String username,String password,String name,String sex,String phone,String IDcard);
	    void updatePersonal(String username,String password,String name,String sex,String phone,String IDcard);
	    void deletePersonal(String username);
	    List<Personal> selectPersonal(String name);

	    void addTravel(String username,String password,String travelID,String travelName,String phone,float VIPPrice);
	    void updateTravel(String username,String password,String travelID,String travelName,String phone,float VIPPrice);
	    void deleteTravel(String username);

	    void addFlight(String flightID,String flightName,String flightTime,String flightplace,String arriveplace,int Price,int Seat);
	    void updateFlight(String flightID,String flightName,String flightTime,String flightplace,String arriveplace,int Price,int Seat);
	    void deleteFlight(String flightID);
	    
	    //添加订单
	    void addOrder(Order order);
	    List<Order> selectOrder(String name,String flightID);//查询到购买的订单
	    String winname(String username);//获取用户真实姓名
	    List<Order> selectprintOrder(String name);//打印机票
	}

	 