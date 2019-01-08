package com.ascent.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ascent.bean.Usr;

public class LoginUserInfoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
    public LoginUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
}
 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
    this.doPost(request, response);
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
HttpSession session = request.getSession();  //创建会话
Usr user = (Usr) session.getAttribute("user");//获取登录用户
String result="";
if(user == null){
result = "您没有登录或已经注销";
}
else{
result = "您已经登录!</br>用户ID："+ user.getId() + "</br>用户名:"+ user.getUsername()+"</br>";
result += "<a href='/text/LogoutServlet'>注销</a>";
}
response.setCharacterEncoding("utf-8");//解决中文字体
response.setContentType("text/html");//设置文件输出类型
PrintWriter out=response.getWriter();//创建输出流
out.println("<html>");
out.println("<head><title>用户信息</title></head>");
out.println("<body>");
out.println(result);
out.println("</body></html>");
out.flush();
out.close();
}
}
 