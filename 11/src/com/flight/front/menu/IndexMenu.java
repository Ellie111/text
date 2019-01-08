package com.flight.front.menu;

import java.util.Scanner;

import com.flight.admin.Menu.AdminLogin;

public class IndexMenu {
	public void Menu(){
        PersonalRegister pr = new PersonalRegister();
        TravelRegister tr = new TravelRegister();
        PersonalLogin pl = new PersonalLogin();
        TravelLogin tl = new TravelLogin();
        int num;
        //String pd = /^[0-9]{1,20}$/;
        System.out.println("###############欢迎来到购买机票系统###############");
        System.out.println("        1、个人旅客登录       2、旅行社登录");
        System.out.println("        3、个人旅客注册       4、旅行社注册");
        System.out.println("        0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        switch (num) {
            case 1:
                pl.login();break;
            case 2:
                tl.login();break;
            case 3:
                pr.register();break;
            case 4:
                tr.register();break;
            case 0:
                break;
            default:
                System.out.println("输入有误！请重新输入！");
                Menu();
                break;
            }
        }
	 public static void main(String args[]){
		 IndexMenu text = new IndexMenu();
	        text.Menu();
	    }

}
