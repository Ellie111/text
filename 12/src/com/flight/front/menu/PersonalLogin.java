package com.flight.front.menu;

import java.util.Scanner;

import com.flight.bean.Order;
import com.flight.bean.Personal;
import com.flight.dao.DBOperationRealize;

public class PersonalLogin {

    public void login(){
        String username;
        String password;
        int num;

        DBOperationRealize dbr = new DBOperationRealize();
        Personal personal = new Personal();
        SearchFlight sf = new SearchFlight();
        Order order = new Order();
        buy buy = new buy();
        
        System.out.println("用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        personal = dbr.getPersonal(username);
        if(personal.getUsername() == null){
            System.out.println("用户名不存在！");
            login();
        }
        else {
            System.out.println("密码：");
            Scanner sc2 = new Scanner(System.in);
            password = sc2.next();
            if(!personal.getPassword().equals(password)){
                System.out.println("密码错误！");
                login();
            }
            else{
            	
                System.out.println("登录成功！");
                System.out.println("###############欢迎您："+username+"###############");
                System.out.println("       1、查询航班     2、购买航班     3、打印机票   0、退出系统");
                System.out.println("###############################################");
                System.out.println("请选择需要的操作：");
                Scanner sc7 = new Scanner(System.in);
                num = sc7.nextInt();
                switch(num){
                    case 1:
                        sf.search(username);break;
                    case 2:
						buy.ad(username);			
                    	break;
                    case 3:
                    	buy.print(username);		
                   	break;
                    case 0:
                        break;
                    default :
                        System.out.println("输入有误！请重新输入！");
                        login();
                        break;
                }
            }
        }
    }
}