package com.csms.dao.inter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.csms.dao.model.UserInfo;

public interface UserInterface {
	
    public int insertUser(UserInfo user) throws ClassNotFoundException, SQLException;
    //增加
    public int delUser(String userLogin) throws ClassNotFoundException, SQLException;
    //删除
    public int updateUser(UserInfo user) throws ClassNotFoundException, SQLException;
    //修改
    public ResultSet queryUser(String strWhere) throws ClassNotFoundException, SQLException;
    //结果
    public int updatePwd(String userLogin,String oldPwd,String newPwd) throws ClassNotFoundException, SQLException;
    //改密码
    public ResultSet loginUser(String userLogin,String userPwd) throws ClassNotFoundException, SQLException;
}
