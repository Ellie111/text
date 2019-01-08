package com.csms.dao.inter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.csms.dao.model.UserInfo;

public interface UserInterface {
	//�����û�
    public int insertUser(UserInfo user) throws ClassNotFoundException, SQLException;
    //ɾ���û�
    public int delUser(String userLogin) throws ClassNotFoundException, SQLException;
    //�޸��û�
    public int updateUser(UserInfo user) throws ClassNotFoundException, SQLException;
    //��ѯ�û�
    public ResultSet queryUser(String strWhere) throws ClassNotFoundException, SQLException;
    //�޸�����
    public int updatePwd(String userLogin,String oldPwd,String newPwd) throws ClassNotFoundException, SQLException;
    //��¼
    public ResultSet loginUser(String userLogin,String userPwd) throws ClassNotFoundException, SQLException;
}
