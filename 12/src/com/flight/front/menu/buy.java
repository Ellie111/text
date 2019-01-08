package com.flight.front.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.Line;

import com.flight.bean.Flight;
import com.flight.bean.Order;
import com.flight.bean.Personal;
import com.flight.dao.DBOperationRealize;
public class buy {

	public void ad(String username){
	    System.out.println("请输入您要购买的航班号");
	    Scanner sc = new Scanner(System.in);
	    String flightID=sc.next();
	    DBOperationRealize dbr = new DBOperationRealize();
	    List a=null;
	    a=dbr.getFlightID(flightID);
	    Flight flight =(Flight)a.get(0);
	   // System.out.println(flight.getFlightID());
	    List b=null;
	    String name =null;
	    name=dbr.winname(username);
	    System.out.println(name);
		b=dbr.selectPersonal(name);
		Personal Person=(Personal)b.get(0);
		Order order=new Order();
		order.setName(Person.getName());
		order.setFlightID(flight.getFlightID());
		order.setFlightName(flight.getFlightName());
		order.setFlightTime(flight.getFlightTime());
		order.setFlightplace(flight.getFlightplace());	   
		order.setArriveplace(flight.getArriveplace());
		order.setPrice(flight.getPrice());	
		dbr.addOrder(order);
		List a1=null;
		a1=dbr.selectOrder(name,flightID);
		for(int i=0;i<a1.size();i++){
			Order order1 = (Order)a1.get(i);
			  System.out.println("您已购买的机票是："+order1.getall());
			 System.out.println("购买成功！");
		}
		}
	
	public void print(String username){
		DBOperationRealize dbr = new DBOperationRealize();
	    String name =null;
	    name=dbr.winname(username);
	    System.out.println(name);
		List a1=null;
		a1=dbr.selectprintOrder(name);
		for(int i=0;i<a1.size();i++){
			Order order1 = (Order)a1.get(i);
			  System.out.println("打印的机票是："+order1.getall());
		}
		}
	    }

