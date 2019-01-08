package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hzyc.jdbc.JDBC;

public class Good {
	
	private String goodsID;
	private String goodsName;
	private String shortName;
	private String goodsClass;
	private String goodsStd;
	private String Price;
	private String Weight;
	private String Volume;
	private String unitID;
	private String Vendor;
	private String lowQuantity;
	private String highQuantity;
	private String safeQuantity;
	private String whID;
	private String highPrice;
	private String lowPrice;
	private String Builder;
	private String modiPerson;
	private String modiTime;
	private String nowQuantity;
	private String lastCleckTime;
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}
	public String getGoodsStd() {
		return goodsStd;
	}
	public void setGoodsStd(String goodsStd) {
		this.goodsStd = goodsStd;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public String getVolume() {
		return Volume;
	}
	public void setVolume(String volume) {
		Volume = volume;
	}
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getLowQuantity() {
		return lowQuantity;
	}
	public void setLowQuantity(String lowQuantity) {
		this.lowQuantity = lowQuantity;
	}
	public String getHighQuantity() {
		return highQuantity;
	}
	public void setHighQuantity(String highQuantity) {
		this.highQuantity = highQuantity;
	}
	public String getSafeQuantity() {
		return safeQuantity;
	}
	public void setSafeQuantity(String safeQuantity) {
		this.safeQuantity = safeQuantity;
	}
	public String getWhID() {
		return whID;
	}
	public void setWhID(String whID) {
		this.whID = whID;
	}
	public String getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}
	public String getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getBuilder() {
		return Builder;
	}
	public void setBuilder(String builder) {
		Builder = builder;
	}
	public String getModiPerson() {
		return modiPerson;
	}
	public void setModiPerson(String modiPerson) {
		this.modiPerson = modiPerson;
	}
	public String getModiTime() {
		return modiTime;
	}
	public void setModiTime(String modiTime) {
		this.modiTime = modiTime;
	}
	public String getNowQuantity() {
		return nowQuantity;
	}
	public void setNowQuantity(String nowQuantity) {
		this.nowQuantity = nowQuantity;
	}
	public String getLastCleckTime() {
		return lastCleckTime;
	}
	public void setLastCleckTime(String lastCleckTime) {
		this.lastCleckTime = lastCleckTime;
	}
	
	public boolean addGood(){
		
		boolean sign=false;
		
		try {
			
			String sql="insert into GDMESS values('"+goodsID+"','"+goodsName+"','"+shortName+"','"+goodsClass+"','"+goodsStd+"','"+Price+"','"+Weight+"','"+Volume+"','"+unitID+"','"+Vendor+"','"+lowQuantity+"','"+highQuantity+"','"+safeQuantity+"','"+whID+"','"+highPrice+"','"+lowPrice+"','"+Builder+"','"+modiPerson+"','"+modiTime+"','"+nowQuantity+"','"+lastCleckTime+"')";
			System.out.println(sql);
			JDBC jt =new JDBC();
			int result=jt.update(sql);
			if(result!=-1){
				sign=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sign;
		
	}
	
	public boolean AddGoods(String sql){
		int result ;
		boolean sign = false ;
		try {
			JDBC jt = new JDBC() ;
			result = jt.update(sql);
			if(result == 1){
				sign = true ;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return sign ;
	}
	
	
	public List<Good> queryGood(){
		List<Good> gList=new ArrayList<Good>();
		try {
			String sql="select *from GDMESS";
			JDBC jt=new JDBC();
			ArrayList<HashMap<String, String>> rsList=jt.query(sql);
			for(int i=0;i<rsList.size();i++){
				Map<String,String> map=rsList.get(i);
				Good cg=new Good();
				cg.setGoodsID(map.get("goodsID"));
				cg.setGoodsName(map.get("goodsName"));
				cg.setShortName(map.get("shortName"));
				cg.setGoodsClass(map.get("goodsClass"));
				cg.setGoodsStd(map.get("goodsStd"));
				cg.setPrice(map.get("Price"));
				cg.setWeight(map.get("Weight"));
				cg.setVolume(map.get("Volume"));
				cg.setUnitID(map.get("unitID"));
				cg.setVendor(map.get("Vendor"));
				cg.setLowQuantity(map.get("lowQuantity"));
				cg.setHighQuantity(map.get("highQuantity"));
				cg.setSafeQuantity(map.get("safeQuantity"));
				cg.setWhID(map.get("WhID"));
				cg.setHighPrice(map.get("highPrice"));
				cg.setLowPrice(map.get("lowPrice"));
				cg.setBuilder(map.get("Builder"));
				cg.setModiPerson(map.get("modiPerson"));
				cg.setModiTime(map.get("modiTime"));
				cg.setNowQuantity(map.get("nowQuantity"));
				cg.setLastCleckTime(map.get("lastCleckTime"));
				gList.add(cg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gList;
	}
	
	
	public boolean updateGood(){
		boolean sign=false;
		try {
			String sql="update GDMESS set goodsName='"+goodsName+"',shortName='"+shortName+"',goodsClass='"+goodsClass+"',goodsStd='"+goodsStd+"',Price='"+Price+"',Weight='"+Weight+"',Volume='"+Volume+"',unitID='"+unitID+"',Vendor='"+Vendor+"',lowQuantity="+lowQuantity+",highQuantity="+highQuantity+",safeQuantity="+safeQuantity+",whID='"+whID+"',lowPrice='"+lowPrice+"',highPrice='"+highPrice+"',Builder='"+Builder+"',modiPerson='"+modiPerson+"',modiTime='"+modiTime+"',nowQuantity="+nowQuantity+",lastCleckTime='"+lastCleckTime+"' where goodsID='"+goodsID+"'";
			JDBC jt=new JDBC();
			int result=jt.update(sql);
			if(result!=-1){
				sign=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
		
		
		
	}
	
	public ArrayList<Good> Select(String sql){		
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			ArrayList<Good> glist = new ArrayList<Good>();
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				Good goods = new Good();
				goods.setGoodsID(hmap.get("goodsID"));
				goods.setGoodsName(hmap.get("goodsName"));
				goods.setShortName(hmap.get("shortName"));
				goods.setGoodsClass(hmap.get("goodsClass"));
				goods.setGoodsStd(hmap.get("goodsStd"));
				goods.setPrice(hmap.get("Price"));
				goods.setWeight(hmap.get("Weight"));
				goods.setVolume(hmap.get("Volume"));
				goods.setUnitID(hmap.get("unitID"));
				goods.setVendor(hmap.get("Vendor"));
				goods.setLowQuantity(hmap.get("lowQuantity"));
				goods.setHighQuantity(hmap.get("highQuantity"));
				goods.setSafeQuantity(hmap.get("safeQuantity"));
				goods.setWhID(hmap.get("whID"));
				goods.setHighPrice(hmap.get("highPrice"));
				goods.setLowPrice(hmap.get("lowPrice"));
				goods.setBuilder(hmap.get("Builder"));
				goods.setModiPerson(hmap.get("modiPerson"));
				goods.setModiTime(hmap.get("modiTime"));
				goods.setNowQuantity(hmap.get("nowQuantity"));
				goods.setLastCleckTime(hmap.get("lastCleckTime"));
				glist.add(goods);
			}
			return glist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null ;
	}
	
	public boolean deleteGood(String id){
		boolean sign=false;
		try {
			String sql="delete from GDMESS where goodsID='"+id+"'";
			JDBC jt=new JDBC();
			int result=jt.update(sql);
			if(result!=-1){
				sign=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
	}
	
	
	public List<Good> checkGood(){
		List<Good> gList=new ArrayList<Good>();
		try {
			String sql="select nowQuantity from GDMESS";
			JDBC db=new JDBC();
			ArrayList<HashMap<String, String>> rsList=db.query(sql);
			for(int i=0;i<rsList.size();i++){
				Map<String,String> map=rsList.get(i);
				Good cg=new Good();
				cg.setGoodsID(map.get("goodsID"));
				
				cg.setWhID(map.get("WhID"));

				gList.add(cg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gList;
	}
	
	
	public ArrayList<Good> Show(){
		try {
			String sql = "select * from GDMESS" ;
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist =  jt.query(sql);
			ArrayList<Good> glist = new ArrayList<Good>();
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Good goods = new Good();
				goods.setGoodsID(hmap.get("goodsID"));
				goods.setGoodsName(hmap.get("goodsName"));
				goods.setShortName(hmap.get("shortName"));
				goods.setGoodsClass(hmap.get("goodsClass"));
				goods.setGoodsStd(hmap.get("goodsStd"));
				goods.setPrice(hmap.get("Price"));
				goods.setWeight(hmap.get("Weight"));
				goods.setVolume(hmap.get("Volume"));
				goods.setUnitID(hmap.get("unitID"));
				goods.setVendor(hmap.get("Vendor"));
				goods.setLowQuantity(hmap.get("lowQuantity"));
				goods.setHighQuantity(hmap.get("highQuantity"));
				goods.setSafeQuantity(hmap.get("safeQuantity"));
				goods.setWhID(hmap.get("whID"));
				goods.setHighPrice(hmap.get("highPrice"));
				goods.setLowPrice(hmap.get("lowPrice"));
				goods.setBuilder(hmap.get("Builder"));
				goods.setModiPerson(hmap.get("modiPerson"));
				goods.setModiTime(hmap.get("modiTime"));
				goods.setNowQuantity(hmap.get("nowQuantity"));
				goods.setLastCleckTime(hmap.get("lastCleckTime"));
				glist.add(goods);
			}
			return glist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	

}
