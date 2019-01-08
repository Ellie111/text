package com.csms.servlet;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.Flags.Flag;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csms.dao.inter.UserInterface;
import com.csms.dao.interImpl.UserImpl;
import com.csms.dao.model.UserInfo;


public class UserServlet extends HttpServlet {
	UserInterface UserInter=new UserImpl();
	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doDelete method of the servlet. <br>
	 *
	 * This method is called when a HTTP delete request is received.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
          String opt=request.getParameter("opt");
          if(opt.equals("login")){
        	  try {
      			doLogin(request, response);
      		} catch (SQLException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		} catch (ClassNotFoundException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}  
          }
		  if(opt.equals("query")){
			  try {
	      			doQuery(request, response,"");
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }
		  if(opt.equals("add")){
			  try {
	      			doAdd(request, response);
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }
		  if(opt.equals("queryForUpdate")){
			  try {
	      			doQueryForUpdate(request, response);
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }
		  if(opt.equals("update")){
			  try {
	      			doUpdate(request, response);
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }
		  if(opt.equals("del")){
			  try {
	      			doDel(request, response);
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }
		  if(opt.equals("updatePwd")){
			  try {
	      			doUpdatePwd(request, response);
	      		} catch (SQLException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		} catch (ClassNotFoundException e) {
	      			// TODO Auto-generated catch block
	      			e.printStackTrace();
	      		}  
		  }

	}
	
	public void doLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		HttpSession session=request.getSession();
		UserInterface userInter = new UserImpl();
		String userLogin = request.getParameter("userLogin");
		String userPwd = request.getParameter("userPwd");
		ResultSet rs = userInter.loginUser(userLogin, userPwd);		
		String msg="";
		if (rs.next()){			
			session.setAttribute("userLogin", userLogin);
			response.sendRedirect("Main.htm");
		}
		else{
			msg="请输入正确的用户名密码！！！";
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			//response.sendRedirect("login.jsp");
		}
	}
	
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		UserInfo user=new UserInfo();
		String userLogin=request.getParameter("login");
		String userName=request.getParameter("name");
		String userPwd=request.getParameter("pwd");
		String userNote=request.getParameter("note");
		user.setFlag(0);
		user.setUserLogin(userLogin);
		user.setUserName(userName);
		user.setUserNote(userNote);
		user.setUserPwd(userPwd);
		UserInter.insertUser(user);
		doQuery(request, response,"数据增加成功");
	}
    
	public void doQuery(HttpServletRequest request, HttpServletResponse response,String msg)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		StringBuffer strWhere=new StringBuffer();
		request.setCharacterEncoding("gbk");
		strWhere.append("1=1");		
		String userName=request.getParameter("name");
		String userLogin=request.getParameter("login");	  		
		if((userName!="" && userName!=null)){
			strWhere.append(" and userName='"+userName+"'");
		}
		if(userLogin!="" && userLogin!=null){
			strWhere.append(" and userLogin='"+userLogin+"'");
		}
		ResultSet rs_user=UserInter.queryUser(strWhere.toString());		
		request.setAttribute("msg", msg);
		request.setAttribute("rsa",rs_user);
		RequestDispatcher rd=request.getRequestDispatcher("/system/USER1001.jsp");
		rd.forward(request, response);
	}
	
	public void doQueryForUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		String userLogin=request.getParameter("hd_login");
		ResultSet rs=UserInter.queryUser(" userLogin='"+userLogin+"'");
		request.setAttribute("rs", rs);
		RequestDispatcher rd=request.getRequestDispatcher("/system/USER1002.jsp");
		rd.forward(request, response);
	}
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		UserInfo user=new UserInfo();
		String userLogin=request.getParameter("login");
		String userName=request.getParameter("name");
		String userPwd=request.getParameter("pwd");
		String userNote=request.getParameter("note");
		user.setFlag(0);
		user.setUserLogin(userLogin);
		user.setUserName(userName);
		user.setUserNote(userNote);
		user.setUserPwd(userPwd);
		UserInter.updateUser(user);
		doQuery(request, response,"数据修改成功");
	}
	
	public void doDel(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		String userLogin=request.getParameter("hd_login");
		UserInter.delUser(userLogin);
		doQuery(request, response,"数据删除成功");
	}
	
	public void doUpdatePwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException, ClassNotFoundException {
		HttpSession session=request.getSession();
		String userLogin=(String)session.getAttribute("userLogin");
		String oldPwd=request.getParameter("oldPwd");
		String newPwd=request.getParameter("newPwd");
		int result=UserInter.updatePwd(userLogin, oldPwd, newPwd);
		String msg="";
		if(result==-1){
			msg="旧密码验证失败";
		}
		else{
			msg="密码修改成功";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("common/password1001.jsp");
		rd.forward(request, response);	
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
