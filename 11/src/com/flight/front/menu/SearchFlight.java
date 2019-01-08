package com.flight.front.menu;

import java.util.List;
import java.util.Scanner;

import com.flight.bean.Flight;
import com.flight.dao.DBOperationRealize;

public class SearchFlight {

	 public void search(String username){
	        int num;

	        IndexMenu indexMenu = new IndexMenu();

	        System.out.println("###############欢迎您："+username+"###############");
	        System.out.println("       1、按航班号查询      2、按起飞时间查询");
	        System.out.println("       3、按起飞日查询      4、查询所有航班");
	        System.out.println("       5、退出登录                    0、退出系统");
	        System.out.println("###############################################");
	        System.out.println("请选择需要的操作：");
	        Scanner sc = new Scanner(System.in);
	        num = sc.nextInt();
	        switch(num){
	            case 1:
	                search_ID();
	                search(username);
	                break;
	            case 2:
	                search_Time();
	                search(username);
	                break;
	            case 3:
	                search_Date();
	                search(username);
	                break;
	            case 4:
	            	search_All();
	                search(username);
	                break;
	            case 5:
	                indexMenu.Menu();break;
	            default :
	                System.out.println("输入有误！请重新输入！");
	                search(username);
	                break;
	        }
	    }

	    public void search_ID(){
	        DBOperationRealize dbr = new DBOperationRealize();
	        Flight flight = new Flight();
	        String flightID;
	        System.out.println("请输入航班号：");
	        Scanner sc = new Scanner(System.in);
	        flightID = sc.next();
	        flight = dbr.getFlight_ID(flightID);
	        if(flight.getFlightID() != null) {
	            System.out.println("航班号：" + flight.getFlightID() + " 航班名：" + flight.getFlightName() + " 起飞日期：" + flight.getFlightDate() + " 起飞时间：" + flight.getFlightTime() + " 到达时间" + flight.getArriveTime() + " 商务舱座位：" + flight.getBusinessSeats() + " 经济舱座位：" + flight.getTouristSeats());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	    }

	    public void search_Time(){
	        DBOperationRealize dbr = new DBOperationRealize();
	        Flight flight = new Flight();
	        String flightTime;
	        System.out.println("请输入起飞时间：");
	        Scanner sc = new Scanner(System.in);
	        flightTime = sc.next();
	        flight = dbr.getFlight_Time(flightTime);
	        System.out.println(flight.getFlightTime());
	        if(flight.getFlightTime() != null) {
	            System.out.println("航班号：" + flight.getFlightID() + " 航班名：" + flight.getFlightName() + " 起飞日期：" + flight.getFlightDate() + " 起飞时间：" + flight.getFlightTime() + " 到达时间" + flight.getArriveTime() + " 商务舱座位：" + flight.getBusinessSeats() + " 经济舱座位：" + flight.getTouristSeats());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	    }

	    public void search_Date(){
	        DBOperationRealize dbr = new DBOperationRealize();
	        Flight flight = new Flight();
	        String flightDate;
	        System.out.println("请输入航班号：");
	        Scanner sc = new Scanner(System.in);
	        flightDate = sc.next();
	        flight = dbr.getFlight_Date(flightDate);
	        if(flight.getFlightDate() != null){
	        System.out.println("航班号："+flight.getFlightID()+" 航班名："+flight.getFlightName()+" 起飞日期："+flight.getFlightDate()+" 起飞时间："+flight.getFlightTime()+" 到达时间"+flight.getArriveTime()+" 商务舱座位："+flight.getBusinessSeats()+" 2经济舱座位："+flight.getTouristSeats());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	    }
	    public void search_All(){
	        DBOperationRealize dbr = new DBOperationRealize();
	        Flight flight = new Flight();
	        flight = dbr.getFlight_ALL();
	        if(flight.getFlightID()!= null){	
	        System.out.println("航班号："+flight.getFlightID()+" 航班名："+flight.getFlightName()+" 起飞日期："+flight.getFlightDate()+" 起飞时间："+flight.getFlightTime()+" 到达时间"+flight.getArriveTime()+" 商务舱座位："+flight.getBusinessSeats()+" 2经济舱座位："+flight.getTouristSeats());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	        
	    }
	}

