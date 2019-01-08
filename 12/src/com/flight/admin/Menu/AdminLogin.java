package com.flight.admin.Menu;

import java.util.Scanner;

import com.flight.bean.Admin;
import com.flight.dao.DBOperationRealize;

public class AdminLogin {

    public void login(){
        String username;
        String password;

        DBOperationRealize dbr = new DBOperationRealize();
        Admin admin = null;
        AdminMenu adminMenu = new AdminMenu();

        System.out.println("###############欢迎来到机票预订系统###############");
        System.out.println("当前为后台管理界面：\n请输入您的用户名跟密码：");
        System.out.println("用户名：");
        Scanner sc1 = new Scanner(System.in);
        username = sc1.next();
        admin = dbr.getAdmin(username);
        if(admin.getUsername() == null){
            System.out.println("管理员账号不正确！");
            login();
        }
        else{
            System.out.println("密码：");
            Scanner sc2 = new Scanner(System.in);
            password = sc2.next();
            if(!admin.getPassword().equals(password)){
                System.out.println("密码错误！");
                login();
            }
            else{
                System.out.println("登陆成功！");
                adminMenu.Menu();
            }
        }
    }
}
