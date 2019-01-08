package com.flight.front.menu;

import java.util.Scanner;

import com.flight.bean.Travel;
import com.flight.dao.DBOperationRealize;

public class TravelLogin {
	 public void login(){
	        String username;
	        String password;
	        int num;

	        DBOperationRealize dbr = new DBOperationRealize();
	        Travel travel = new Travel();
	        SearchFlight sf = new SearchFlight();

	        System.out.println("用户名：");
	        Scanner sc1 = new Scanner(System.in);
	        username = sc1.next();
	        travel = dbr.getTravel(username);
	        if(travel.getUsername() == null){
	            System.out.println("用户名不存在！");
	            login();
	        }
	        else {
	            System.out.println("密码：");
	            Scanner sc2 = new Scanner(System.in);
	            password = sc2.next();
	            if(travel.getPassword().equals(password)){
	                System.out.println("登录成功！");
	                System.out.println("###############欢迎您："+username+"###############");
	                System.out.println("       1、查询航班        0、退出系统");
	                System.out.println("###############################################");
	                System.out.println("请选择需要的操作：");
	                Scanner sc7 = new Scanner(System.in);
	                num = sc7.nextInt();
	                switch(num){
	                    case 1:
	                        sf.search(username);break;
	                    case 0:
	                        break;
	                    default :
	                        System.out.println("输入有误！请重新输入！");
	                        login();
	                        break;
	                }

	            }
	            else{
	                System.out.println("密码错误！");
	                login();
	            }
	        }
	    }
	}