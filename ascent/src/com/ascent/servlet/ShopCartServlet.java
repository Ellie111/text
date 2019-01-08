package com.ascent.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.util.ShopCart;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc=null;
   
    public ShopCartServlet() {
        super();
    }
    
    public void inti()throws ServletException{
    	super.init();
    	sc=this.getServletContext();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String stste=request.getParameter("a");
		if(stste.equals("add")){
			this.addShopCart(request,response);
			
		}
	}
	public void destory(){
		
	}

	@SuppressWarnings("unused")
	private void addShopCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		ShopCart cart=(ShopCart)session.getAttribute("shopcart");
		if(cart==null){
			cart=new ShopCart();
			session.setAttribute("shopcart", cart);
		}
		String pid=request.getParameter("pid");
		int ppid=Integer.parseInt(pid);
		boolean bl=cart.checkHashMapid(pid);
		if(bl){
			String dthtml="该产品已经保存在购物车里！";
					response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(dthtml);
		}
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
