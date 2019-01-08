package com.flight.bean;

public class Travel {

	private String username;         //用户名
    private String password;         //密码
    private String travelID;         //旅行社编号
    private String travelName;       //旅行社名称
    private String phone;            //电话
    private float VIPPrice;          //折扣率

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTravelID() {
        return travelID;
    }

    public void setTravelID(String travelID) {
        this.travelID = travelID;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getVIPPrice() {
        return VIPPrice;
    }

    public void setVIPPrice(float VIPPrice) {
        this.VIPPrice = VIPPrice;
    }


}
