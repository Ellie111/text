package com.flight.admin.Menu;

import java.util.Scanner;

import com.flight.bean.Personal;
import com.flight.dao.DBOperationRealize;

public class PersonalManager {

    //旅客管理界面
    public void p_menu(){
        //用户选择按钮
        int num;
        //创建主后台界面对象，后面用来返回到主后台界面
        AdminMenu adminMenu = new AdminMenu();
        //旅客管理界面
        System.out.println("###############欢迎来到机票预订系统###############");
        System.out.println(" ###############当前为旅客管理界面###############");
        System.out.println("      1、添加旅客          2、修改旅客信息");
        System.out.println("      3、删除旅客          4、返回后台管理首页");
        System.out.println("      0、退出系统");
        System.out.println("###############################################");
        System.out.println("请选择需要的操作：");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        switch(num){
            case 1:
                add();
                p_menu();
                break;
            case 2:
                update();
                p_menu();
                break;
            case 3:
                delete();
                p_menu();
                break;
            case 4:
                adminMenu.Menu();
                break;
            case 0:
                break;
            default:
                System.out.println("输入有误！请重新输入！");
                p_menu();
                break;
        }
    }

    //添加旅客
    public void add(){
        String username;
        String password;
        String name;
        String sex;
        String phone;
        String IDcard;


        DBOperationRealize dbr = new DBOperationRealize();
        Personal personal = null;

        System.out.println("用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        personal = dbr.getPersonal(username);
        if(personal.getUsername() != null){
            System.out.println("用户名已存在！");
            add();
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
        }
    }

    //修改旅客
    public void update(){
        String username;
        String password;
        String name;
        String sex;
        String phone;
        String IDcard;

        DBOperationRealize dbr = new DBOperationRealize();
        Personal personal = null;

        System.out.println("请输入要修改旅客的用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        personal = dbr.getPersonal(username);
        if(personal.getUsername() == null){
            System.out.println("没有该用户名！");
            update();
        }
        else{
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
            dbr.updatePersonal(username,password,name,sex,phone,IDcard);
            System.out.println("修改成功！");
        }
    }

    //删除旅客
    public void delete(){
        String username;

        DBOperationRealize dbr = new DBOperationRealize();
        Personal personal = null;

        System.out.println("请输入要删除旅客的用户名：");
        Scanner sc = new Scanner(System.in);
        username = sc.next();
        personal = dbr.getPersonal(username);
        if(personal.getUsername() == null){
            System.out.println("没有该用户名！");
            delete();
        }
        else{
            dbr.deletePersonal(username);
            System.out.println("删除成功！");
        }
    }
}

 
