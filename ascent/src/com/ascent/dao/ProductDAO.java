package com.ascent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ascent.bean.Product;
import com.ascent.util.DataAccess;

public class ProductDAO {
	public List<Product>getAllProduct(){
		  Connection con = DataAccess.getConnection();
		  String sql = "select * from product p order by p.id";
		  List<Product>list = new ArrayList<Product>();
		  Statement stmt = null;
		  ResultSet rs = null;
		  try{
		   stmt = con.createStatement();
		   rs=stmt.executeQuery(sql);
		   while(rs.next()){
			Product pr = new Product();
		    pr.setId(rs.getInt("id"));
		    pr.setProductnumber(rs.getString("productnumber"));
		    pr.setProductname(rs.getString("productname"));
		    pr.setCategoryno(rs.getString("categoryno"));
		    pr.setCategory(rs.getString("Category"));
		    pr.setImagepath(rs.getString("Imagepath"));
		    pr.setIsnewproduct(rs.getString("isnewproduct"));
		    pr.setPrice1(rs.getFloat("price1"));
		    pr.setPrice2(rs.getFloat("price2"));
		    pr.setRealstock(rs.getString("realstock"));
		    pr.setStock(rs.getString("stock"));
		    pr.setCas(rs.getString("cas"));
		    pr.setWeight(rs.getString("weight"));
		    pr.setDelsoft(rs.getString("delsoft"));
		    list.add(pr);
		    
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally{
		   try{
		    if(rs!=null){
		     rs.close();
		    }
		    if(stmt!=null){
		     stmt.close();
		    }
		    if(con!=null){
		     con.close();
		    }
		   }catch(Exception e2){
		    e2.printStackTrace();
		   }
		  }
		  System.out.println("listproduct:"+list);
		  return list;
		 }
}
