package com.flight.bean;

public class Flight {
	 private String flightID;         //航班号
	    private String flightName;       //航班名称
	    private String flightDate;       //起飞日期
	    private String flightTime;       //起飞时间
	    private String arriveTime;       //到达时间
	    private int businessSeats;       //商务舱座位
	    private int touristSeats;        //经济舱座位

	    public String getFlightID() {
	        return flightID;
	    }

	    public void setFlightID(String flightID) {
	        this.flightID = flightID;
	    }

	    public String getFlightName() {
	        return flightName;
	    }

	    public void setFlightName(String flightName) {
	        this.flightName = flightName;
	    }

	    public String getFlightDate() {
	        return flightDate;
	    }

	    public void setFlightDate(String flightDate) {
	        this.flightDate = flightDate;
	    }

	    public String getFlightTime() {
	        return flightTime;
	    }

	    public void setFlightTime(String flightTime) {
	        this.flightTime = flightTime;
	    }

	    public String getArriveTime() {
	        return arriveTime;
	    }

	    public void setArriveTime(String arriveTime) {
	        this.arriveTime = arriveTime;
	    }

	    public int getBusinessSeats() {
	        return businessSeats;
	    }

	    public void setBusinessSeats(int businessSeats) {
	        this.businessSeats = businessSeats;
	    }

	    public int getTouristSeats() {
	        return touristSeats;
	    }

	    public void setTouristSeats(int touristSeats) {
	        this.touristSeats = touristSeats;
	    }


	}
