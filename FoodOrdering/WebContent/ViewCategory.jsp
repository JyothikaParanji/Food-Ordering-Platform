<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="hotel.DAO.UserService"%>
<%@page import="hotel.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel.Constants.GlobalConstants"%>
<%
	ArrayList<Category> cats = new UserService().getAllCategory();
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
				<div class="templatemo_product_box">
					<h1>View Category</h1>
					<form action="cook?action=addCategory" method="post">
						<table width="100%" style="text-align: center;">
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
								<th>Name</th>
							</tr>
							<% if(cats != null && cats.size() != 0) {
								for(int i=0; i< cats.size();i++){
									Category cat = cats.get(i);
							%>
							<tr>
								<td><%= i+1  %></td>
								<td><a href="ViewItems.jsp?categoryId=<%=cat.getCategoryId()%>"><%= cat.getName() %></a>

								</td>
							</tr>
							<%}} %>
						</table>

					</form>
				</div>
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