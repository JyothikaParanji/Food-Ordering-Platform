<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.awt.print.Book"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="hotel.Login"%>
<%@page import="hotel.OrderMaster.OrderStatus"%>
<%@page import="hotel.DAO.CookServices"%>
<%@page import="hotel.OrderMaster"%>
<%@page import="hotel.Item"%>
<%@page import="hotel.Category"%>
<%@page import="hotel.DAO.UserService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel.Constants.GlobalConstants"%>
<%! 
boolean isLastOrderDeliverd = Boolean.FALSE;
boolean isLongTime = Boolean.FALSE;

%>

<%
Login l = (Login) session.getAttribute(GlobalConstants.USER);
ArrayList<OrderMaster> orders = new UserService().getAllOrders(Integer.parseInt(l.getUserName()));
//System.out.println("isLastOrderDeliverd - "+isLastOrderDeliverd+" isLongTime - "+isLongTime);
if(isLastOrderDeliverd)
{
	//System.out.println("in isLastOrderDeliverd ");
	
	if(session.getAttribute("isLastOrdered") == null && session.getAttribute("time" ) == null)
	{
		//session.setAttribute("isLastOrdered", isLastOrderDeliverd);	
		session.setAttribute("time", new Date());
		System.out.println("session set");
	}
	
}

if(session.getAttribute("isLastOrdered") != null && session.getAttribute("time") != null)
{	
	//System.out.println("is "+session.getAttribute("isLastOrdered")+" time = "+session.getAttribute("time"));
	
	Date date = (Date) session.getAttribute("time");
	Date update = new Date();
	//System.out.println("date is = " + date.getTime() +"      "+update.getTime());
	
	long diff = date.getTime() - update.getTime();
	 
	long diffSeconds = diff / 1000 % 60;
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	long diffDays = diff / (24 * 60 * 60 * 1000);

	//System.out.print(diffDays + " days, ");
	//System.out.println(diffHours + " hours, ");
	//System.out.println(diffMinutes + " minutes, ");
	//System.out.println(diffSeconds + " seconds.");
	if(diffHours >= -1)
	{
		//System.out.println("your time is over");
		isLongTime = Boolean.TRUE;
	}

}
else
{ 
	System.out.println("some values are null");
	session.setAttribute("time", null);
	session.setAttribute("isLastOrdered", null);
}
	
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="5" http-equiv="refresh" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Food Ordering System</title>
<link href="resources/css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!--  Free CSS Templates from www.templatemo.com -->
	<div id="templatemo_container">
		<!-- end of menu -->
		<div id="templatemo_content_bar">
			<div class="templatemo_product_box">
				<h1></h1>
			</div>
		</div>
		<div id="templatemo_header">
			
		</div>
		<!-- end of header -->
		<div id="templatemo_content_bar">
			<div class="templatemo_product_box">
				<h1></h1>
			</div>
		</div>
		<div id="templatemo_content">

			<div id="templatemo_content_left">
				<jsp:include page="Menu.jsp" />
			</div>
			<!-- end of content left -->
			<div id="templatemo_content_right">
				<table width="100%" style="text-align: center;">
					<%
								if (!GlobalConstants.MESSAGE.equals("")
										&& GlobalConstants.MESSAGE != null) {
									out.write("<tr><td colspan='3' align='center' style=''color:white;visibility:visible'> "
											+ GlobalConstants.MESSAGE + " </td></tr>");
									GlobalConstants.MESSAGE = "";
								}
								if(isLongTime)
									{%>
									<span style="text-decoration:blink;font-size: large; color: red"> Your time is Over you have free this table for other Customers </span>
							<%}%>
					<% if(orders.size() != 0 && orders != null) {%>
					<tr>
						<th>Sr No</th>
						<th>Customer Number</th>
						<th>Name</th>
						<th>Status</th>
					</tr>
					<% for(int i=0;i<orders.size();i++)
						{
							OrderMaster om = orders.get(i);
						%>
					<tr>
						<td><%=i+1 %> <input type="hidden" name="id"
							value="<%= om.getId()%>" /></td>
						<td><%=om.getCustomerNumber() %></td>
						<td><a
							href="ViewOrderedItemsList.jsp?id=<%=om.getId() %>"><%=om.getOrderName() %>
						</a></td>
						<td><%=om.getOrderStatus().name() %></td>
						<% if(om.getOrderStatus().name().equals(OrderMaster.OrderStatus.DELIVERED.name())) 
							{isLastOrderDeliverd = Boolean.TRUE;} else {isLastOrderDeliverd = Boolean.FALSE;}
							%>
					</tr>
					<%}
						} else {%>
					<tr>
						<td>No Orders Available</td>
					</tr>
					<%} %>
				</table>
				<div class="cleaner_with_height">&nbsp;</div>
			</div>
			<!-- end of content right -->

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->

		<div id="templatemo_footer">
			<a href="HomePage.html">Home</a> | <a href="LoginPage.jsp"> Admin Login
			</a> | <a href="LoginPage.jsp">Customer Login </a> | <a href="AboutUs.html">About
				Us</a> | <a href="ContactUs.html">Contact Us</a>
		</div>
		<!-- end of footer -->
		<!--  Free CSS Template www.templatemo.com -->
	</div>
	<!-- end of container -->
</body>
</html>