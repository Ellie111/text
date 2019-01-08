package com.flight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flight.bean.Admin;
import com.flight.bean.Flight;
import com.flight.bean.Personal;
import com.flight.bean.Travel;
import com.flight.util.DBConnection;

public class DBOperationRealize implements DBOperation{

    //查询管理员账号密码
    public Admin getAdmin(String username){
        Admin admin = new Admin();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from admin where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    //查询个人旅客的信息
    public Personal getPersonal(String username) {
        Personal person = new Personal();
        Connection conn = DBConnection.getConnection();
        String sql = "Select * from personal where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setName(rs.getString("name"));
                person.setSex(rs.getString("sex"));
                person.setPhone(rs.getString("phone"));
                person.setIDcard(rs.getString("IDcard"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }
    //查询旅行社信息
    public Travel getTravel(String username) {
        Travel travel = new Travel();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from travel where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                travel.setUsername(rs.getString("username"));
                travel.setPassword(rs.getString("password"));
                travel.setTravelID(rs.getString("travelID"));
                travel.setTravelName(rs.getString("travelName"));
                travel.setPhone(rs.getString("phone"));
                travel.setVIPPrice(rs.getFloat("VIPPrice"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return travel;
    }
    //通过ID查询航班信息
    public Flight getFlight_ID(String flightID) {
        Flight flight = new Flight();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight where flightID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightDate(rs.getString("flightDate"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setArriveTime(rs.getString("arriveTime"));
                flight.setBusinessSeats(rs.getInt("businessSeats"));
                flight.setTouristSeats(rs.getInt("touristSeats"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

    //通过起飞日查询航班信息
    public Flight getFlight_Date(String flightDate) {
        Flight flight = new Flight();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight where flightDate = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightDate);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightDate(rs.getString("flightDate"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setArriveTime(rs.getString("arriveTime"));
                flight.setBusinessSeats(rs.getInt("businessSeats"));
                flight.setTouristSeats(rs.getInt("touristSeats"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }
    //通过起飞时间查询航班信息
    public Flight getFlight_Time(String flightTime) {
        Flight flight = new Flight();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight where flightTime = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightTime);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightDate(rs.getString("flightDate"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setArriveTime(rs.getString("arriveTime"));
                flight.setBusinessSeats(rs.getInt("businessSeats"));
                flight.setTouristSeats(rs.getInt("touristSeats"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }
    
    //查询所有航班
    public Flight getFlight_ALL() {
        Flight flight = new Flight();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightDate(rs.getString("flightDate"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setArriveTime(rs.getString("arriveTime"));
                flight.setBusinessSeats(rs.getInt("businessSeats"));
                flight.setTouristSeats(rs.getInt("touristSeats"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }
    //添加一个新旅客
    public void addPersonal(String username, String password, String name, String sex, String phone, String IDcard) {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into personal(username,password,name,sex,phone,IDcard) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setString(4,sex);
            ps.setString(5,phone);
            ps.setString(6,IDcard);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("注册失败！");
            e.printStackTrace();
        }
    }

    //更新旅客信息
    public void updatePersonal(String username, String password, String name, String sex, String phone, String IDcard){
        Connection conn = DBConnection.getConnection();
        String sql = "update personal set password = ?,name = ?,sex = ?,phone = ?,IDcard = ? where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,name);
            ps.setString(3,sex);
            ps.setString(4,phone);
            ps.setString(5,IDcard);
            ps.setString(6,username);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("更新失败！");
            e.printStackTrace();
        }
    }

    //删除旅客
    public void deletePersonal(String username){
        Connection conn = DBConnection.getConnection();
        String sql = "delete from personal where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("删除失败！");
            e.printStackTrace();
        }
    }

    //添加一个新旅行社
    public void addTravel(String username, String password, String travelID, String travelName, String phone, float VIPPrice) {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into travel(username,password,travelID,travelName,phone,VIPPrice) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,travelID);
            ps.setString(4,travelName);
            ps.setString(5,phone);
            ps.setFloat(6,VIPPrice);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("注册失败！");
            e.printStackTrace();
        }
    }

    //更新旅行社信息
    public void updateTravel(String username, String password, String travelID, String travelName, String phone, float VIPPrice){
        Connection conn = DBConnection.getConnection();
        String sql = "update travel set password = ?,travelID = ?,travelName = ?,phone = ?,VIPPrice = ? where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,travelID);
            ps.setString(3,travelName);
            ps.setString(4,phone);
            ps.setFloat(5,VIPPrice);
            ps.setString(6,username);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("更新失败！");
            e.printStackTrace();
        }
    }

    //删除旅行社
    public void deleteTravel(String username){
        Connection conn = DBConnection.getConnection();
        String sql = "delete from travel where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("删除失败！");
            e.printStackTrace();
        }
    }

    //添加航班
    public void addFlight(String flightID,String flightName,String flightDate,String flightTime,String arriveTime,int businessSeats,int touristSeats){
        Connection conn = DBConnection.getConnection();
        String sql = "insert into flight(flightID,flightName,flightDate,flightTime,arriveTime,businessSeats,touristSeats) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightID);
            ps.setString(2,flightName);
            ps.setString(3,flightDate);
            ps.setString(4,flightTime);
            ps.setString(5,arriveTime);
            ps.setInt(6,businessSeats);
            ps.setInt(7,touristSeats);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("添加失败！");
            e.printStackTrace();
        }
    }

    //更新航班信息
    public void updateFlight(String flightID,String flightName,String flightDate,String flightTime,String arriveTime,int businessSeats,int touristSeats){
        Connection conn = DBConnection.getConnection();
        String sql = "update flight set flightName = ?,flightDate = ?,flightTime = ?,arriveTime = ?,businessSeats = ?,touristSeats = ? where flightID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightName);
            ps.setString(2,flightDate);
            ps.setString(3,flightTime);
            ps.setString(4,arriveTime);
            ps.setInt(5,businessSeats);
            ps.setInt(6,touristSeats);
            ps.setString(7,flightID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("更新失败！");
            e.printStackTrace();
        }
    }

    //删除航班
    public void deleteFlight(String flightID){
        Connection conn = DBConnection.getConnection();
        String sql = "delete from flight where flightID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightID);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("删除失败！");
            e.printStackTrace();
        }
    }

}
