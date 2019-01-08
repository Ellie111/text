package com.flight.dao;

import com.flight.bean.Admin;
import com.flight.bean.Flight;
import com.flight.bean.Personal;
import com.flight.bean.Travel;

public interface DBOperation {
	 Admin getAdmin(String username);
	    Personal getPersonal(String username);
	    Travel getTravel(String username);
	    
	    Flight getFlight_ID(String flightID);
	    Flight getFlight_Date(String flightID);
	    Flight getFlight_Time(String flightID);
	    Flight getFlight_ALL();

	    void addPersonal(String username,String password,String name,String sex,String phone,String IDcard);
	    void updatePersonal(String username,String password,String name,String sex,String phone,String IDcard);
	    void deletePersonal(String username);

	    void addTravel(String username,String password,String travelID,String travelName,String phone,float VIPPrice);
	    void updateTravel(String username,String password,String travelID,String travelName,String phone,float VIPPrice);
	    void deleteTravel(String username);

	    void addFlight(String flightID,String flightName,String flightDate,String flightTime,String arriveTime,int businessSeats,int touristSeats);
	    void updateFlight(String flightID,String flightName,String flightDate,String flightTime,String arriveTime,int businessSeats,int touristSeats);
	    void deleteFlight(String flightID);
	}

	 