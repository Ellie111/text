package com.bean;

public class Flight {

    private String fNo;     //航班编号
    private String fName;     // 航班名称
    private String planeType;     // 飞机型号
    private String startTime;     // 起飞时间
    private String endTime;     //到达时间
    private String startCity; // 出发城市
    private String endCity;     //到达城市
    private String ecoTicket;     //经济舱余票
    private String ecoTicketPrice;     //经济舱票价
    private String VIPTicket;     //商务舱余票
    private String VIPTicketPrice;     //商务舱票价
    public Flight(){}
    /**
     * @param fNo
     * @param fName
     * @param planeType
     * @param startTime
     * @param endTime
     * @param startCity
     * @param endCity
     * @param ecoTicket
     * @param ecoTicketPrice
     * @param vIPTicket
     * @param vIPTicketPrice
     */
          public Flight(String fNo, String fName, String planeType, String startTime, String endTime, String startCity,
         String endCity, String ecoTicket, String ecoTicketPrice, String vIPTicket, String vIPTicketPrice)
    {
    this.fNo = fNo;
    this.fName = fName;
    this.planeType = planeType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startCity = startCity;
    this.endCity = endCity;
    this.ecoTicket = ecoTicket;
    this.ecoTicketPrice = ecoTicketPrice;
    VIPTicket = vIPTicket;
    VIPTicketPrice = vIPTicketPrice;
    }
    public String getfNo()
    {
    return fNo;
    }
    public void setfNo(String fNo)
    {
    this.fNo = fNo;
    }
    public String getfName()
    {
    return fName;
    }
    public void setfName(String fName)
    {
    this.fName = fName;
    }
    public String getPlaneType()
    {
    return planeType;
    }
    public void setPlaneType(String planeType)
    {
    this.planeType = planeType;
    }
    public String getStartTime()
    {
    return startTime;
    }
    public void setStartTime(String startTime)
    {
    this.startTime = startTime;
    }
    public String getEndTime()
    {
    return endTime;
    }
    public void setEndTime(String endTime)
    {
    this.endTime = endTime;
    }
    public String getStartCity()
    {
    return startCity;
    }
    public void setStartCity(String startCity)
    {
    this.startCity = startCity;
    }
    public String getEndCity()
    {
    return endCity;
    }
    public void setEndCity(String endCity)
    {
    this.endCity = endCity;
    }
    public String getEcoTicket()
    {
    return ecoTicket;
    }
    public void setEcoTicket(String ecoTicket)
    {
    this.ecoTicket = ecoTicket;
    }
    public String getEcoTicketPrice()
    {
    return ecoTicketPrice;
    }
    public void setEcoTicketPrice(String ecoTicketPrice)
    {
    this.ecoTicketPrice = ecoTicketPrice;
    }
    public String getVIPTicket()
    {
    return VIPTicket;
    }
    public void setVIPTicket(String vIPTicket)
    {
    VIPTicket = vIPTicket;
    }
    public String getVIPTicketPrice()
    {
    return VIPTicketPrice;
    }
    public void setVIPTicketPrice(String vIPTicketPrice)
    {
    VIPTicketPrice = vIPTicketPrice;
    }
}
