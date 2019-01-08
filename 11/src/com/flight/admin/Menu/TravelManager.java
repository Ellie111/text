package com.flight.admin.Menu;

import java.util.Scanner;

import com.flight.bean.Travel;
import com.flight.dao.DBOperationRealize;

public class TravelManager {
	public void t_menu(){
        int num;

        AdminMenu adminMenu = new AdminMenu();

        System.out.println("###############欢迎来到机票预订系统###############");
        System.out.println("###############当前为旅行社管理界面###############");
        System.out.println("      1、添加旅行社          2、修改旅行社信息");
        System.out.println("      3、删除旅行社          4、返回后台管理首页");
        System.out.println("      0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        switch(num){
            case 1:
                add();
                t_menu();
                break;
            case 2:
                update();
                t_menu();
                break;
            case 3:
                delete();
                t_menu();
                break;
            case 4:
                adminMenu.Menu();
                break;
            case 0:
                break;
            default :
                System.out.println("输入有误！请重新输入！");
                t_menu();
                break;
        }
    }

    //添加旅行社
    public void add(){
        String username;
        String password;
        String travelID;
        String travelName;
        String phone;
        float VIPPrice;


        DBOperationRealize dbr = new DBOperationRealize();
        Travel travel = null;

        System.out.println("用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        travel = dbr.getTravel(username);
        if(travel.getUsername() != null){
            System.out.println("用户名已存在！");
            add();
        }
        else {
            System.out.println("密码：");
            Scanner sc2 = new Scanner(System.in);
            password = sc2.next();
            System.out.println("旅行社ID：");
            Scanner sc3 = new Scanner(System.in);
            travelID = sc3.next();
            System.out.println("旅行社名称：");
            Scanner sc4 = new Scanner(System.in);
            travelName = sc4.next();
            System.out.println("旅行社电话：");
            Scanner sc5 = new Scanner(System.in);
            phone = sc5.next();
            System.out.println("VIP折扣：");
            Scanner sc6 = new Scanner(System.in);
            VIPPrice = sc6.nextFloat();
            dbr.addTravel(username, password, travelID, travelName, phone, VIPPrice);
            System.out.println("添加成功！");
        }
    }

    //修改旅行社信息
    public void update(){
        String username;
        String password;
        String travelID;
        String travelName;
        String phone;
        float VIPPrice;


        DBOperationRealize dbr = new DBOperationRealize();
        Travel travel = null;

        System.out.println("请输入要修改旅行社的用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        travel = dbr.getTravel(username);
        if(travel.getUsername() == null){
            System.out.println("没有该用户名！");
            update();
        }
        else{
            System.out.println("密码：");
            Scanner sc2 = new Scanner(System.in);
            password = sc2.next();
            System.out.println("旅行社ID：");
            Scanner sc3 = new Scanner(System.in);
            travelID = sc3.next();
            System.out.println("旅行社名称：");
            Scanner sc4 = new Scanner(System.in);
            travelName = sc4.next();
            System.out.println("旅行社电话：");
            Scanner sc5 = new Scanner(System.in);
            phone = sc5.next();
            System.out.println("VIP折扣：");
            Scanner sc6 = new Scanner(System.in);
            VIPPrice = sc6.nextFloat();
            dbr.updateTravel(username,password,travelID,travelName,phone,VIPPrice);
            System.out.println("修改成功！");
        }
    }

    //删除旅行社
    public void delete(){
        String username;

        DBOperationRealize dbr = new DBOperationRealize();
        Travel travel = null;

        System.out.println("请输入要删除旅行社的用户名：");
        Scanner sc = new Scanner(System.in);
        username = sc.next();
        travel = dbr.getTravel(username);
        if(travel.getUsername() == null){
            System.out.println("没有该用户名！");
            delete();
        }
        else{
            dbr.deleteTravel(username);
            System.out.println("删除成功！");
        }
    }
}