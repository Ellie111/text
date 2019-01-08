package com.flight.admin.Menu;

import java.util.List;
import java.util.Scanner;

import com.flight.bean.Flight;
import com.flight.dao.DBOperationRealize;

public class FlightManager {
	//航班管理菜单
    public void f_menu(){
        int num;

        AdminMenu adminMenu = new AdminMenu();

        System.out.println("###############欢迎来到机票购买系统###############");
        System.out.println(" ###############当前为航班管理界面###############");
        System.out.println("      1、添加航班                       2、修改航班信息");
        System.out.println("      3、删除航班                       4、查询航班");
        System.out.println("      5、返回后台管理首页         0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        switch(num){
            case 1:
                add();
                f_menu();
                break;
            case 2:
                update();
                f_menu();
                break;
            case 3:
                delete();
                f_menu();
                break;
            case 4:
                select();
                f_menu();
                break;
            case 5:
                adminMenu.Menu();
                break;
            case 0:
                break;
            default :
                System.out.println("输入有误！请重新输入！");
                f_menu();
                break;
        }
    }

    public void select() {
		// TODO Auto-generated method stub
    	  DBOperationRealize dbr = new DBOperationRealize();     
	        List a=null;
	        a=(List)dbr.getFlight_ALL();
		  for(int i=0;i<a.size();i++){
	        	Flight flight = (Flight)a.get(i);
	        	System.out.println((i+1)+":"+flight.getall());
	        	}
	}

	//添加航班
    public void add(){
    	String flightID;
        String flightName;
        String flightTime;
        String flightplace;
        String arriveplace;
        int Price;
        int Seat;

        DBOperationRealize dbr = new DBOperationRealize();
        Flight flight = new Flight();

        System.out.println("航班号：");
        Scanner sc1 = new Scanner(System.in);
        flightID = sc1.next();
        flight = dbr.getFlight_ID(flightID);
        if(flight.getFlightID() != null){
            System.out.println("该航班已存在！");
            add();
        }
        else {
            System.out.println("航班名称：");
            Scanner sc2 = new Scanner(System.in);
            flightName = sc2.next();
            System.out.println("起飞时间：");
            Scanner sc3 = new Scanner(System.in);
            flightTime = sc3.next();
            System.out.println("起飞地点：");
            Scanner sc4 = new Scanner(System.in);
            flightplace = sc4.next();
            System.out.println("到达地点：");
            Scanner sc5 = new Scanner(System.in);
            arriveplace = sc5.next();
            System.out.println("价格：");
            Scanner sc6 = new Scanner(System.in);
            Price = sc6.nextInt();
            System.out.println("座位：");
            Scanner sc7 = new Scanner(System.in);
            Seat = sc7.nextInt();
            dbr.addFlight(flightID,flightName,flightTime,flightplace,arriveplace,Price,Seat);
            System.out.println("添加成功！");
        }
    }
    
    //修改航班信息
    public static void update(){
        String flightID;
        String flightName;
        String flightplace;
        String flightTime;
        String arriveplace;
        int Price;
        int Seats;

        DBOperationRealize dbr = new DBOperationRealize();
        Flight flight = new Flight();

        System.out.println("请输入要修改航班的航班号：");
        Scanner sc1 = new Scanner(System.in);
        flightID = sc1.next();
        flight = dbr.getFlight_ID(flightID);
        if(flight.getFlightID() == null){
            System.out.println("没有该航班！");
            update();
        }
        else {
            System.out.println("航班名称：");
            Scanner sc2 = new Scanner(System.in);
            flightName = sc2.next();
            System.out.println("起飞时间：");
            Scanner sc3 = new Scanner(System.in);
            flightTime = sc3.next();
            System.out.println("起飞地点：");
            Scanner sc4 = new Scanner(System.in);
            flightplace = sc4.next();
            System.out.println("到达地点：");
            Scanner sc5 = new Scanner(System.in);
            arriveplace = sc5.next();
            System.out.println("价格：");
            Scanner sc6 = new Scanner(System.in);
            Price = sc6.nextInt();
            System.out.println("座位：");
            Scanner sc7 = new Scanner(System.in);
            Seats = sc7.nextInt();
            dbr.updateFlight(flightID,flightName,flightTime,flightplace,arriveplace,Price,Seats);
            System.out.println("修改成功！");
        }
    }

    //删除航班
    public void delete(){
        String flightID;

        DBOperationRealize dbr = new DBOperationRealize();
        Flight flight = new Flight();

        System.out.println("请输入要删除航班的ID：");
        Scanner sc = new Scanner(System.in);
        flightID = sc.next();
        flight = dbr.getFlight_ID(flightID);
        if(flight.getFlightID() == null){
            System.out.println("没有该航班！");
            delete();
        }
        else{
            dbr.deleteFlight(flightID);
            System.out.println("删除成功！");
        }
    }
}