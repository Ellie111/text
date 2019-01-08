package com.flight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flight.bean.Admin;
import com.flight.bean.Flight;
import com.flight.bean.Order;
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
    public Order getOrder(String name){
    	Order order = new Order();
         Connection conn = DBConnection.getConnection();
         String sql = "select * from forder where name = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,name);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
            	 order.setName(rs.getString("name"));
            	 order.setFlightID(rs.getString("FlightID"));
            	 order.setFlightName(rs.getString("flightName"));
            	 order.setFlightplace(rs.getString("flightplace"));
            	 order.setFlightTime(rs.getString("flightTime"));
            	 order.setArriveplace(rs.getString("arriveplace"));
            	 order.setPrice(rs.getInt("price"));
             }
             rs.close();
             ps.close();
             conn.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return order;
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
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setFlightplace(rs.getString("flightplace"));
                flight.setArriveplace(rs.getString("arriveplace"));
                flight.setPrice(rs.getInt("price"));
                flight.setSeat(rs.getInt("Seat"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

    //通过起飞地点和到达地点查询航班信息
    public Flight getFlight_Place(String flightplace,String arriveplace) {
        Flight flight = new Flight();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight where flightplace = ? and arriveplace = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightplace);
            ps.setString(2,arriveplace);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	 flight.setFlightID(rs.getString("flightID"));
                 flight.setFlightName(rs.getString("flightName"));
                 flight.setFlightTime(rs.getString("flightTime"));
                 flight.setFlightplace(rs.getString("flightplace"));
                 flight.setArriveplace(rs.getString("arriveplace"));
                 flight.setPrice(rs.getInt("price"));
                 flight.setSeat(rs.getInt("Seat"));
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
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setFlightplace(rs.getString("flightplace"));
                flight.setArriveplace(rs.getString("arriveplace"));
                flight.setPrice(rs.getInt("price"));
                flight.setSeat(rs.getInt("Seat"));
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
    public List<Flight> getFlight_ALL(){      
   	 List<Flight> list =new ArrayList<Flight>();
    	// Flight flight=null;
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Flight flight = new Flight();
            	flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setFlightplace(rs.getString("flightplace"));
                flight.setArriveplace(rs.getString("arriveplace"));
                flight.setPrice(rs.getInt("price"));
                flight.setSeat(rs.getInt("Seat"));
                list.add(flight);
               
            }
       rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return list;
    }
    
    public List<Flight> getFlightID(String flightID) {
    	List<Flight> list =new ArrayList<Flight>();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from flight where flightID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Flight flight = new Flight();
                flight.setFlightID(rs.getString("flightID"));
                flight.setFlightName(rs.getString("flightName"));
                flight.setFlightTime(rs.getString("flightTime"));
                flight.setFlightplace(rs.getString("flightplace"));
                flight.setArriveplace(rs.getString("arriveplace"));
                flight.setPrice(rs.getInt("price"));
                flight.setSeat(rs.getInt("Seat"));
                list.add(flight);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
    public void addFlight(String flightID,String flightName,String flightTime,String flightplace,String arriveplace,int Price,int Seat){
        Connection conn = DBConnection.getConnection();
        String sql = "insert into flight(flightID,flightName,flightTime,flightplace,arriveplace,Price,Seat) value(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightID);
            ps.setString(2,flightName);
            ps.setString(3,flightTime);
            ps.setString(4,flightplace);
            ps.setString(5,arriveplace);
            ps.setInt(6,Price);
            ps.setInt(7,Seat);
            ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("添加失败！");
            e.printStackTrace();
        }
    }

    //更新航班信息
    public void updateFlight(String flightID,String flightName,String flightTime,String flightplace,String arriveplace,int Price,int Seat){
        Connection conn = DBConnection.getConnection();
        String sql = "update flight set flightName = ?,flightTime = ?,flightplace = ?,arriveplace = ?,Price = ?,Seat = ? where flightID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,flightName);
            ps.setString(2,flightTime);
            ps.setString(3,flightplace);
            ps.setString(4,arriveplace);
            ps.setInt(5,Price);
            ps.setInt(6,Seat);
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
    //添加订单
//	public void addOrder(String name, String flightID, String flightName, String flightTime, String flightplace,
//			String arriveplace, int price) {
//		   Connection conn = DBConnection.getConnection();
//	        String sql = "insert into order(name,flightID,flightName,flightTime,flightplace,arriveplace,Price) value(?,?,?,?,?,?,?)";
//	        try {
//	            PreparedStatement ps = conn.prepareStatement(sql);
//	            ps.setString(1,name);
//	            ps.setString(2,flightID);
//	            ps.setString(3,flightName);
//	            ps.setString(4,flightTime);
//	            ps.setString(5,flightplace);
//	            ps.setString(6,arriveplace);
//	            ps.setInt(7,price);
//	            ps.executeUpdate();
//	            ps.close();
//	            conn.close();
//	        } catch (SQLException e) {
//	            System.out.println("添加失败！");
//	            e.printStackTrace();
//	        }
//	    }
//		
    
    public void addOrder(Order order){
    	 Connection conn = DBConnection.getConnection();
    	 String sql1 = "select * from forder where flightID ='"+order.getFlightID()+"' and name='"+order.getName()+"'";
           try {
               PreparedStatement ps = conn.prepareStatement(sql1);
               ResultSet rs = ps.executeQuery();
    			if(rs.next()){
    				 System.out.println("已经购买过，不能重复添加");
    				ps.close();
    			}else{
    				 String sql2 = "insert into forder(name,flightID,flightName,flightTime,flightplace,arriveplace,Price) value(?,?,?,?,?,?,?)";
    				 ps=conn.prepareStatement(sql2);
    				 ps.setString(1,order.getName());
    				 ps.setString(2, order.getFlightID());
    				 ps.setString(3, order.getFlightName());
    				 ps.setString(4, order.getFlightTime());
    				 ps.setString(5, order.getFlightplace());
    				 ps.setString(6, order.getArriveplace());
    				 ps.setInt(7, order.getPrice());
    				 ps.executeUpdate();
    		         ps.close();
    		         conn.close();
    			}
    			}catch (SQLException e) {
    	            System.out.println("购票失败！");
    	            e.printStackTrace();
    	        }
    }
    public List<Personal> selectPersonal(String name){
    	List<Personal> list =new ArrayList<Personal>();
        Connection conn = DBConnection.getConnection();
        String sql = "select * from personal where name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	Personal person = new Personal();
            	  person.setUsername(rs.getString("username"));
                  person.setPassword(rs.getString("password"));
                  person.setName(rs.getString("name"));
                  person.setSex(rs.getString("sex"));
                  person.setPhone(rs.getString("phone"));
                  person.setIDcard(rs.getString("IDcard"));
                  list.add(person);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Order> selectprintOrder(String name){
    	List<Order> list =new ArrayList<Order>();
   	 Connection conn = DBConnection.getConnection();
   	  String sql = "select * from forder where name = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, name);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
           	 Order order = new Order();
           	 order.setName(rs.getString("name"));
            	 order.setFlightID(rs.getString("FlightID"));
            	 order.setFlightName(rs.getString("flightName"));
            	 order.setFlightplace(rs.getString("flightplace"));
            	 order.setFlightTime(rs.getString("flightTime"));
            	 order.setArriveplace(rs.getString("arriveplace"));
            	 order.setPrice(rs.getInt("price"));
            	 list.add(order);
             }
             rs.close();
             ps.close();
             conn.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }

         return list;
     }
    public List<Order> selectOrder(String name,String flightID){
    	List<Order> list =new ArrayList<Order>();
    	 Connection conn = DBConnection.getConnection();
    	  String sql = "select * from forder where name = ? and flightID= ?";
          try {
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, name);
              ps.setString(2, flightID);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
            	 Order order = new Order();
            	 order.setName(rs.getString("name"));
             	 order.setFlightID(rs.getString("FlightID"));
             	 order.setFlightName(rs.getString("flightName"));
             	 order.setFlightplace(rs.getString("flightplace"));
             	 order.setFlightTime(rs.getString("flightTime"));
             	 order.setArriveplace(rs.getString("arriveplace"));
             	 order.setPrice(rs.getInt("price"));
             	 list.add(order);
              }
              rs.close();
              ps.close();
              conn.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }

          return list;
      }
   
    
public String winname(String username) {
	String a=null;
	 Personal personal = new Personal();
	Connection conn = DBConnection.getConnection();
	  String sql = "select * from personal where username =?";
	  try {
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1,username);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
        	a=rs.getString("name");
        	  //a=username;
          }
          rs.close();
          ps.close();
          conn.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return a;
}
}
