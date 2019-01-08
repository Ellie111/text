package com.flight.front.menu;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.flight.bean.Flight;
import com.flight.dao.DBOperationRealize;

public class SearchFlight {

	 public void search(String username){
	        int num;

	        IndexMenu indexMenu = new IndexMenu();

	        System.out.println("###############欢迎您："+username+"###############");
	        System.out.println("       1、按航班号查询                             2、按起飞时间查询");
	        System.out.println("       3、按起飞地点和到达地点查询       4、查询所有航班");
	        System.out.println("       5、退出登录                                     0、退出系统");
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
	                search_Place();
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
	            System.out.println("航班号：" + flight.getFlightID() + " 航班名：" + flight.getFlightName() + " 起飞日期：" + flight.getFlightTime() + " 起飞地点：" + flight.getFlightplace() + " 到达地点" + flight.getArriveplace()+ " 价格：" + flight.getPrice() + " 座位：" + flight.getSeat());
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
	            System.out.println("航班号：" + flight.getFlightID() + " 航班名：" + flight.getFlightName() + " 起飞日期：" + flight.getFlightTime() + " 起飞地点：" + flight.getFlightplace() + " 到达地点" + flight.getArriveplace()+ " 价格：" + flight.getPrice() + " 座位：" + flight.getSeat());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	    }

	    public void search_Place(){
	        DBOperationRealize dbr = new DBOperationRealize();
	        Flight flight = new Flight();
	        String flightplace;
	        String arriveplace;
	        System.out.println("请输入起飞地点：");
	        Scanner sc = new Scanner(System.in);
	        flightplace = sc.next();
	        System.out.println("请输入到达地点：");
	        Scanner sc1 = new Scanner(System.in);
	        arriveplace =sc1.next();
	        flight = dbr.getFlight_Place(flightplace,arriveplace);
	        if(flight.getFlightTime() != null){
	        System.out.println("航班号：" + flight.getFlightID() + " 航班名：" + flight.getFlightName() + " 起飞日期：" + flight.getFlightTime() + " 起飞地点：" + flight.getFlightplace() + " 到达地点" + flight.getArriveplace()+ " 价格：" + flight.getPrice() + " 座位：" + flight.getSeat());
	        }
	        else{
	            System.out.println("没有满足您需求的航班！");
	        }
	    }
	    
	    public void search_All(){
	        DBOperationRealize dbr = new DBOperationRealize();     
	        List a=null;
	        a=(List)dbr.getFlight_ALL();
		  for(int i=0;i<a.size();i++){
	        	Flight flight = (Flight)a.get(i);
	        	System.out.println((i+1)+":"+flight.getall());
		  }  	     
	    }
	    }
	    
	    


