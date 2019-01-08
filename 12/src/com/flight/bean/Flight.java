package com.flight.bean;

public class Flight {
		private String flightID;         //航班号
	    private String flightName;       //航班名称
	    private String flightTime;       //起飞时间
	    private String flightplace;       //起飞地点
	    private String arriveplace;       //到达地点
	    private int Price;       //价格
	    private int Seat;        //座位

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

		public String getFlightTime() {
			return flightTime;
		}

		public void setFlightTime(String flightTime) {
			this.flightTime = flightTime;
		}

		public String getFlightplace() {
			return flightplace;
		}

		public void setFlightplace(String flightplace) {
			this.flightplace = flightplace;
		}

		public String getArriveplace() {
			return arriveplace;
		}

		public void setArriveplace(String arriveplace) {
			this.arriveplace = arriveplace;
		}

		public int getPrice() {
			return Price;
		}

		public void setPrice(int price) {
			Price = price;
		}

		public int getSeat() {
			return Seat;
		}

		public void setSeat(int seat) {
			Seat = seat;
		}
		public String getall() {
		return"航班号：" + flightID + " 航班名：" + flightName+ " 起飞日期：" + flightTime + " 起飞地点：" + flightplace + " 到达地点" + arriveplace+ " 价格：" + Price + " 座位：" +Seat;
	}
}