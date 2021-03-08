<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="hotel.OrderDetails"%>
<%@page import="hotel.Constants.GlobalConstants"%>
<%@page import="hotel.OrderMaster.OrderStatus"%>
<%@page import="hotel.OrderMaster.OrderStatus"%>
<%@page import="hotel.OrderMaster"%>
<%@page import="hotel.DAO.CookServices"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<OrderDetails> orders = null;
	if(request.getParameter("orderId") != null )
	 orders = new CookServices().getAllItems(Integer.parseInt(request.getParameter("orderId")));
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="refresh" content="4" />
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


			<div style="width: 100%">
				<h1>View Order Items</h1>
				<table
					style="width: 75%; margin: 20px; padding: 20px; border-style: double; text-align: center;">
					<%
								if (!GlobalConstants.MESSAGE.equals("")
										&& GlobalConstants.MESSAGE != null) {
									out.write("<tr><td colspan='3' align='center' style=''color:white;visibility:visible'> "
											+ GlobalConstants.MESSAGE + " </td></tr>");
									GlobalConstants.MESSAGE = "";
								}
							%>
					<% if(orders.size() != 0 && orders != null) {%>
					<tr>
						<th>Sl No</th>
						<th>Customer Number</th>
						<th>Order Id</th>
						<th>Item Name</th>
						<th>Quantity</th>
						<th>Actual Status</th>
					</tr>
					<% for(int i=0;i<orders.size();i++)
						{
							OrderDetails om = orders.get(i);
						%>
					<form action="cook?action=updateItemStatus" method="post">
						<tr>
							<td><%=i+1 %></td>
							<td><%=om.getCustomerNumber() %></td>
							<td><%=om.getId() %> <input type="hidden" name="orderId"
								value="<%= om.getId()%>" /> <input type="hidden" name="itemId"
								value="<%=om.getItemId() %>" /></td>
							<td><%=om.getName() %></td>
							<td><%=om.getQuantity() %></td>
							<td><%=om.getOrderStatus().name() %></td>
						</tr>
					</form>
					<%}
						} else {%>
					<tr>
						<td>No Orders Available</td>
					</tr>
					<%} %>
				</table>
				<a href="OrderStatus.jsp"> Back </a>

				<div class="cleaner_with_height">&nbsp;</div>

				<a href="subpage.html"></a>
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