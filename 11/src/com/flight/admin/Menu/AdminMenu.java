package com.flight.admin.Menu;

import java.util.Scanner;

import com.flight.front.menu.IndexMenu;

public class AdminMenu {
	public void Menu(){

        int num;

        PersonalManager pm = new PersonalManager();
        TravelManager tm = new TravelManager();
        FlightManager fm = new FlightManager();

        System.out.println("###############欢迎来到航空公司系统###############");
        System.out.println(" ###############当前为后台管理界面###############");
        System.out.println("     1、旅客管理           2、旅行社管理");
        System.out.println("     3、航班管理           0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc3 = new Scanner(System.in);
        num = sc3.nextInt();
        switch(num){
            case 1:
                pm.p_menu();
                break;
            case 2:
                tm.t_menu();
                break;
            case 3:
                fm.f_menu();
                break;
            case 0:
                break;
            default :
                System.out.println("输入有误！请重新输入！");
                Menu();
                break;
        }
    }
	public static void main(String args[]){
		AdminMenu text = new AdminMenu();
	        text.Menu();
	    }

}

 