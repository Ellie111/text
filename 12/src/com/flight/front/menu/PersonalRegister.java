package com.flight.front.menu;

import java.util.Scanner;

import com.flight.bean.Personal;
import com.flight.dao.DBOperationRealize;

public class PersonalRegister {

	public void register(){
        String username;
        String password;
        String name;
        String sex;
        String phone;
        String IDcard;
        int num;

        IndexMenu indexMenu = new IndexMenu();
        DBOperationRealize dbr = new DBOperationRealize();
        Personal personal = null;

        System.out.println("请输入您的信息：");
        System.out.println("用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        personal = dbr.getPersonal(username);
        if(personal.getUsername() != null){
            System.out.println("用户名已存在！");
            register();
        }
        else {
            System.out.println("密码：");
            Scanner sc2 = new Scanner(System.in);
            password = sc2.next();
            System.out.println("姓名：");
            Scanner sc3 = new Scanner(System.in);
            name = sc3.next();
            System.out.println("性别：");
            Scanner sc4 = new Scanner(System.in);
            sex = sc4.next();
            System.out.println("电话：");
            Scanner sc5 = new Scanner(System.in);
            phone = sc5.next();
            System.out.println("身份证：");
            Scanner sc6 = new Scanner(System.in);
            IDcard = sc6.next();
            dbr.addPersonal(username, password, name, sex, phone, IDcard);
            System.out.println("注册成功！");
            System.out.println("###############欢迎来到机票预订系统###############");
            System.out.println("       1、返回首页登录        0、退出系统");
            System.out.println("###############################################");
            System.out.println("请选择需要的操作：");
            Scanner sc7 = new Scanner(System.in);
            num = sc7.nextInt();
            switch(num){
                case 1:
                    indexMenu.Menu();break;
                case 0:
                    break;
                default :
                    System.out.println("输入有误！请重新输入！");
                    register();
                    break;
            }
        }

    }
}