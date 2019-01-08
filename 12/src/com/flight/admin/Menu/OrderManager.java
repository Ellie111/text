package com.flight.admin.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.flight.bean.Order;
import com.flight.dao.DBOperationRealize;

public class OrderManager {

    //订单管理界面
    public void o_menu(){
        //用户选择按钮
        int num;
        //创建主后台界面对象，后面用来返回到主后台界面
        AdminMenu adminMenu = new AdminMenu();
        //旅客管理界面
        System.out.println("###############欢迎来到机票预订系统###############");
        System.out.println(" ###############当前为订单管理界面###############");
        System.out.println("      1、添加订单            0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        switch(num){
            case 1:
                add();
                o_menu();
                break;
            case 0:
                break;
            default:
                System.out.println("输入有误！请重新输入！");
                o_menu();
                break;
        }
    }

    //添加旅客
    public void add(){
    	  String name;             //姓名
    	  String flightID;         //航班号
    	  String flightName;       //航班名称
    	  String flightTime;       //起飞时间
    	  String flightplace;       //起飞地点
    	  String arriveplace;       //到达地点
    	   int Price;       //价格
        DBOperationRealize dbr = new DBOperationRealize();
        Order order = null;
        System.out.println("航班号：");
        Scanner sc = new Scanner(System.in);
        flightID = sc.next();
        order = dbr.getOrder(flightID);
        if(order.getName() != null){
            System.out.println("该航班已添加！");
            add();
        }
        else {
            System.out.println("姓名：");
            Scanner sc2 = new Scanner(System.in);
            name = sc2.next();
            System.out.println("航班名称:");
            Scanner sc3 = new Scanner(System.in);  
            flightName = sc3.next();
            System.out.println("起飞时间:");
            Scanner sc4 = new Scanner(System.in);
            flightTime = sc4.next();
            System.out.println("起飞地点：");
            Scanner sc5 = new Scanner(System.in);
            flightplace = sc5.next();
            System.out.println("到达地点：");
            Scanner sc6 = new Scanner(System.in);
            arriveplace = sc6.next();
            System.out.println("到达地点：");
	        Scanner sc7 = new Scanner(System.in);
            Price = sc7.nextInt();
	     dbr.addOrder(order);
	     System.out.println("购票成功！");
        }
    }
    
  
}
