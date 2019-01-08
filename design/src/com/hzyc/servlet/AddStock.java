package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Stock;

public class AddStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String Code = request.getParameter("Code") ;
			String opeTypeID = request.getParameter("opeTypeID") ;
			String vouchType = request.getParameter("vouchType") ;
			String whID = request.getParameter("whID") ;
			String Depart = request.getParameter("Depart") ;
			String Clerk = request.getParameter("Clerk") ;
			String Operator = request.getParameter("Operator") ;
			String opTime = request.getParameter("opTime") ;
			String Vendor = request.getParameter("Vendor") ;
			String Customer = request.getParameter("Customer") ;
			String Summ = request.getParameter("Summ") ;
			String orderCode = request.getParameter("orderCode") ;
			String receiveCode = request.getParameter("receiveCode") ;
			String invoiceCode = request.getParameter("invoiceCode") ;
			String dispatchCode = request.getParameter("dispatchCode") ;
			String Memo = request.getParameter("Memo") ;
			System.out.println("11111111111111111111111111111111111");
			
			Stock st = new Stock() ;
			st.setCode(Code);
			st.setOpeTypeID(opeTypeID);
			st.setVouchType(vouchType);
			st.setWhID(whID);
			st.setDepart(Depart);
			st.setClerk(Clerk);
			st.setOperator(Operator);
			st.setOpTime(opTime);
			st.setVendor(Vendor);
			st.setCustomer(Customer);
			st.setSumm(Summ);
			st.setOrderCode(orderCode);
			st.setReceiveCode(receiveCode);
			st.setInvoiceCode(invoiceCode);
			st.setDispathCode(dispatchCode);
			st.setMemo(Memo);
			
			String sql = "insert into MSTOCK values ('"+Code+"','"+opeTypeID+"' ,'"+vouchType+"','"+whID+"','"+Depart+"','"+Clerk+"','"+Operator+"','"+opTime+"','"+Vendor+"','"+Customer+"','"+Summ+"','"+orderCode+"','"+receiveCode+"','"+invoiceCode+"','"+dispatchCode+"','"+Memo+"')" ;
			boolean sign = st.Update(sql);
			if(sign){
				ArrayList<Stock> slist = st.Show() ;
				request.setAttribute("slist", slist);
				request.getRequestDispatcher("ShowStock.jsp").forward(request, response);
			}else{
				response.sendRedirect("fail.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
