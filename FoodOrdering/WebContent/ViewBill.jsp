<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="hotel.Login"%>
<%@page import="hotel.BillDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel.DAO.UserService"%>
<%@page import="hotel.Constants.GlobalConstants"%>
<%
	UserService uService = new UserService();
	Login login = (Login) session.getAttribute(GlobalConstants.USER);
	ArrayList<BillDetails> bDetails = uService.getBill(Integer.parseInt(login.getUserName()));
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
			<% if(bDetails != null && !bDetails.isEmpty()) {%>			
					<table
						style="width: 90%; margin: 20px; padding: 20px; border-style: double">
						<%
								if (!GlobalConstants.MESSAGE.equals("")
										&& GlobalConstants.MESSAGE != null) {
									out.write("<tr><td colspan='3' align='center' style=''color:white;visibility:visible'> "
											+ GlobalConstants.MESSAGE + " </td></tr>");
									GlobalConstants.MESSAGE = "";
								}
							%>
						<tr>
							<th>Sr No</th>
							<th>Order Name</th>
							<th>Item Name</th>
							<th>Item Cost</th>
							<th>Item Quantity</th>
							<th>Order Quantity</th>
							<th>Amount</th>
						</tr>
						<% double total = 0; %>
						<%for(int i=0; i < bDetails.size(); i++)
						{
							BillDetails bd = bDetails.get(i);
						%>
						<tr>
							<td><%=i+1 %></td>
							<td><%=bd.getOrderName() %></td>
							<td><%=bd.getItemName() %></td>
							<td><%=bd.getItemCost() %></td>
							<td><%=bd.getItemQuantity() %></td>
							<td><%=bd.getOrderQuantity() %></td>
							<td> <%=Double.parseDouble(bd.getItemCost()) * bd.getOrderQuantity() %>
							<% total = (Double.parseDouble(bd.getItemCost()) * bd.getOrderQuantity()) + total; %>
							</td>
						</tr>
						<%}%>
						<tr>
							<td style="text-align: center;"> Total </td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td > <%=total %></td>
						</tr>						
					</table>
					<%}%>
										
				<div class="cleaner_with_height">&nbsp;</div>

			</div>
			<!-- end of content right -->

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->

		<div id="templatemo_footer">
			<a href="HomePage.html">Home</a> | <a href="LoginPage.jsp"> Admin Login
			</a> | <a href="LoginPage.jsp">Customer Login </a> | <a href="AboutUs.html">About
				Us</a> | <a href="ContactUs.html">Contact Us</a>		</div>
		<!-- end of footer -->
		<!--  Free CSS Template www.templatemo.com -->
	</div>
	<!-- end of container -->
</body>
</html>