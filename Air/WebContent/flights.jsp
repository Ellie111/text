<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 航班信息页</title>
     <style type="text/css">
          *{ margin:0; padding:0;}
          body { font:12px/1.5 Arial; color:#666; background:#fff;}
          ul,li{ list-style:none;}
          img{border:0 none;}
          /*---------------------------------------demo css--------------------------------------------*/
          .date_selector, .date_selector *{width: auto;height: auto;border: none;background: none;margin: 0;padding: 0;text-align: left;text-decoration: none;}
          .date_selector{background:#fbfbfb;border: 1px solid #ccc;padding: 10px;margin:0;margin-top:-1px;position: absolute;z-index:100000;display:none;border-radius: 3px;box-shadow: 0 0 5px #aaa;box-shadow:0 2px 2px #ccc; width:220px;}
          .date_selector_ieframe{position: absolute;z-index: 99999;display: none;}
          .date_selector .nav{width: 17.5em;}
          .date_selector .nav p{clear: none;}
          .date_selector .month_nav, .date_selector .year_nav{margin: 0 0 3px 0;padding: 0;display: block;position: relative;text-align: center;}
          .date_selector .month_nav{float: left;width: 55%;}
          .date_selector .year_nav{float: right;width: 42%;margin-right: -8px;}
          .date_selector .month_name, .date_selector .year_name{font-weight: bold;line-height: 20px;}
          .date_selector .button{display: block;position: absolute;top: 0;width:18px;height:18px;line-height:16px;font-weight:bold;color:#5985c7;text-align: center;font-size:12px;overflow:hidden;border: 1px solid #ccc;border-radius:2px;}
          .date_selector .button:hover, .date_selector .button.hover{background:#5985c7;color: #fff;cursor: pointer;border-color:#3a930d;}
          .date_selector .prev{left: 0;}
          .date_selector .next{right: 0;}
          .date_selector table{border-spacing: 0;border-collapse: collapse;clear: both;margin: 0; width:220px;}
          .date_selector th, .date_selector td{width: 2.5em;height: 2em;padding: 0 !important;text-align: center !important;color: #666;font-weight: normal;}
          .date_selector th{font-size: 12px;}
          .date_selector td{border:1px solid #f1f1f1;line-height: 2em;text-align: center;white-space: nowrap;color:#5985c7;background: #fff;}
          .date_selector td.today{background: #eee;}
          .date_selector td.unselected_month{color: #ccc;}
          .date_selector td.selectable_day{cursor: pointer;}
          .date_selector td.selected{background:#2b579a;color: #fff;font-weight: bold;}
          .date_selector td.selectable_day:hover, .date_selector td.selectable_day.hover{background:#5985c7;color: #fff;}
          /*-----------------------------------------------------------------------------------*/
     .ll{
     width:226px;
     background: #fefefe;
     border: 1px solid #bbb;
     font-size: 14px;
     color: #333;
     padding: 7px;
     border-radius: 3px;
     }
     </style>
     <script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
     <script type="text/javascript" src="js/jquery.date_input.pack.js" ></script>
     <script type="text/javascript" src="js/jquery.validate.js"></script>
     <script type="text/javascript">
          $(function(){
          $('.date_picker').date_input();
          $("form").validate({
               rules:{
                    start_city:"required",
                    end_city:"required",
               },
               messages:{
                    start_city:"出发城市不能为空!",
                    end_city:"到达城市不能为空!",
               }
               });
          })
     </script>
     </head>
     <body>
     <form action="FllightServlet" method="post">
          出发城市:<input class="ll" type="text" name="start_city"/> 目的城市：
          <input type="text" class="ll" name="end_city"/>
          出发时间：<input      class="date_picker ll" name="date">
          <input type="submit" value="查询">
     </form>
     <a href="updateinfo.jsp">修改信息</a>
     <!-- 下面显示航班信息 -->
     <% 
          //从session中取出航班信息
          if (request.getAttribute("flights") != null)
          {
     %>
     <table border="1"      align="center" style="width:850px;">
          <tr>
          <th>航班编号</th>
          <th>航班名称</th>
          <th>飞机型号</th>
          <th>起飞时间</th>
          <th>到达时间</th>
          <th>起飞城市</th>
          <th>到达城市</th>
          <th>经济舱余票</th>
          <th>经济舱票价</th>
          <th>商务舱余票</th>
          <th>商务舱票价</th>
          </tr>
          <% 
               @SuppressWarnings("unchecked") 
               List<Flight> flights = (List<Flight>)request.getAttribute("flights");
               for(Flight f : flights)
               {
               out.println("<tr>");
               out.println("<td>" + f.getfNo() + "</td>");
               out.println("<td>" + f.getfName() + "</td>");
               out.println("<td>" + f.getPlaneType() + "</td>");
               out.println("<td>" + f.getStartTime() + "</td>");
               out.println("<td>" + f.getEndTime() + "</td>");
               out.println("<td>" + f.getStartCity() + "</td>");
               out.println("<td>" + f.getEndCity() + "</td>");
               out.println("<td>" + f.getEcoTicket() + "</td>");
               out.println("<td>" + f.getEcoTicketPrice() + "</td>");
               out.println("<td>" + f.getVIPTicket() + "</td>");
               out.println("<td>" + f.getVIPTicketPrice() + "</td>");
               out.println("</tr>");
               }%>
     </table>
     <%}%>
     <%
          if (request.getAttribute("flights") == null && request.getAttribute("mess") != null)
          {
          out.println(request.getAttribute("mess"));
          }
     %>
     </body>
</html>