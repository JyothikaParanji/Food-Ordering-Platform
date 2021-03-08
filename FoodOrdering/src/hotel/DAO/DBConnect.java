 package hotel.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import hotel.BillDetails;
import hotel.Category;
import hotel.Item;
import hotel.Login;
import hotel.OrderDetails;
import hotel.OrderMaster;
import hotel.OrderMaster.OrderStatus;

public class DBConnect {
	private static Connection connection = null;
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String DATABASE_NAME = "hotel";
	private static String DB_URL = "jdbc:mysql://localhost:3306/"
			+ DBConnect.DATABASE_NAME;
	private static String USER_NAME = "root";
	private static String PASSWORD = "";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME,
					PASSWORD);
			return con;
		} catch (ClassNotFoundException cne) {
			System.out.println(cne);
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
		return con;
	}

	public void closeConnection() {
		try {

			if (connection != null)
				connection.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.toString());
		}
	}

	public boolean checkLogin(Login login) {
		String SQL = "select userName,password from login where userName='"
				+ login.getUserName() + "' and password='" + login.getPassword()
				+ "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;
				else
					result = Boolean.FALSE;
				closeConnection();
			} else {
				System.out.println("Connection is null in checkLogin");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in checkLogin - " + sqle);
		}
		return result;
	}

	public boolean isAlreadyExists(String name) {
		String SQL = "select name from category where name='" + name + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in isAlreadyExists");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in isAlreadyExists - " + sqle);
		}
		return result;
	}

	public boolean addCategory(String name) {
		String SQL = "insert into category(name) values('" + name + "')";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in addCategory");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in addCategory - " + sqle);
		}
		return result;

	}

	public boolean isItemAlreadyExists(String itemName) {
		String SQL = "select name from item where name='" + itemName + "'";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				if (rs.next())
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in isItemAlreadyExists");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in isItemAlreadyExists - " + sqle);
		}
		return result;
	}

	public boolean addItem(Item item) {
		String SQL = "insert into item(name, categoryId, quantity, cost) values('"
				+ item.getName() + "', " + item.getCategoryId() + ", "
				+ item.getQuantity() + ", '" + item.getCost() + "')";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in addCategory");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in addCategory - " + sqle);
		}
		return result;

	}

	
	public ArrayList<Category> getAllCategory() {
		String SQL = "SELECT * FROM category";
		ArrayList<Category> cats = new ArrayList<Category>();
		Category c = null;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					c = new Category();
					c.setCategoryId(rs.getInt("categoryId"));
					c.setName(rs.getString("name"));
					cats.add(c);
				}
				closeConnection();
			} else {
				System.out.println("connection is null getAllCategory");
			}
		} catch (Exception e) {
			System.out.println("sqle in addCategory - " + e);
		}
		return cats;
	}

	public ArrayList<OrderMaster> getAllOrders() {
		String SQL = "SELECT * FROM ordermaster where status !='"
				+ OrderStatus.DELIVERED.name() + "' and orderDate = curdate()";
		ArrayList<OrderMaster> os = new ArrayList<OrderMaster>();
		OrderMaster om = null;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					om = new OrderMaster();
					om.setId(rs.getInt("id"));
					om.setCustomerNumber(rs.getInt("customerNumber"));
					om.setOrderName(rs.getString("customerName"));
					om.setOrderDate(rs.getDate("orderDate").toString());
					om.setOrderDate(rs.getString("orderTime"));
					om.setOrderStatus(OrderMaster.getOrderStatus(rs
							.getString("status")));


					os.add(om);
				}
				closeConnection();
			} else {
				System.out.println("connection is null in getAllOrders");
			}
		} catch (Exception e) {
			System.out.println("sqle in getAllOrders - " + e);
		}
		return os;
	}

	public boolean updateOrderStatus(int orderId, String status) {
		String SQL = "UPDATE ordermaster SET status='" + status
				+ "' where id=" + orderId;
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in updateOrderStatus");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in updateOrderStatus - " + sqle);
		}
		return result;
	}

	public ArrayList<OrderDetails> getAllItems(int orderId) {
		String SQL = "SELECT ordermaster.id,category.categoryId, ordermaster.customerNumber, item.itemId, item.name, orderdetails.quantity, item.cost, orderdetails.status"
				+ " FROM ordermaster,orderdetails, item,category"
				+ " WHERE ordermaster.id = orderdetails.orderId and orderdetails.itemId = item.itemId "
				+ "and ordermaster.id="
				+ orderId;
		ArrayList<OrderDetails> ods = new ArrayList<OrderDetails>();
		OrderDetails od = null;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					od = new OrderDetails();
					od.setId(rs.getInt("ordermaster.id"));
					od.setCustomerNumber(rs.getInt("ordermaster.customerNumber"));
					od.setItemId(rs.getInt("item.itemId"));
					od.setName(rs.getString("item.name"));
					od.setQuantity(rs.getInt("orderdetails.quantity"));
					od.setCost(rs.getString("item.cost"));
					od.setCategoryId(rs.getInt("category.categoryId"));
					od.setOrderStatus(OrderDetails.getOrderStatus(rs
							.getString("orderdetails.status")));
					ods.add(od);
				}
				closeConnection();
			} else {
				System.out.println("connection is null in getAllItems(oID)");
			}
		} catch (Exception e) {
			System.out.println("sqle in getAllItems(oId) - " + e);
		}
		return ods;
	}

	public boolean updateItemStatus(int orderId, int itemId, String status) {
		String SQL = "UPDATE orderdetails SET status='" + status
				+ "' where orderId=" + orderId + " and itemId=" + itemId;
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in updateItemStatus");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in updateItemStatus - " + sqle);
		}
		return result;
	}

	public ArrayList<Item> getAllItemsByCategory(int categoryId) {
		String SQL = "SELECT * FROM item where categoryId=" + categoryId;
		ArrayList<Item> items = new ArrayList<Item>();
		Item i = null;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					i = new Item();
					i.setItemId(rs.getInt("itemId"));
					i.setCategoryId(rs.getInt("categoryId"));
					i.setName(rs.getString("name"));
					i.setQuantity(rs.getInt("quantity"));
					i.setCost(rs.getString("cost"));
					items.add(i);
				}
				closeConnection();
			} else {
				System.out
						.println("connection is null in getAllItemsByCategory(itemId)");
			}
		} catch (Exception e) {
			System.out.println("sqle in getAllItemsByCategory(itemId) - " + e);
		}
		return items;
	}

	public ArrayList<OrderMaster> getAllOrders(int customerNumber) {
		String SQL = "SELECT * FROM ordermaster where orderDate = curdate() and customerNumber="
				+ customerNumber;
		ArrayList<OrderMaster> os = new ArrayList<OrderMaster>();
		OrderMaster om = null;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next()) {
					om = new OrderMaster();
					om.setId(rs.getInt("id"));
					om.setCustomerNumber(rs.getInt("customerNumber"));
					om.setOrderName(rs.getString("customerName"));
					om.setOrderDate(rs.getDate("orderDate").toString());
					om.setOrderDate(rs.getString("orderTime"));
					om.setOrderStatus(OrderMaster.getOrderStatus(rs
							.getString("status")));

					os.add(om);
				}
				closeConnection();
			} else {
				System.out
						.println("connection is null in getAllOrders(customerNumber)");
			}
		} catch (Exception e) {
			System.out.println("sqle in getAllOrders(customerNumber) - " + e);
		}
		return os;
	}

	public boolean addOrder(OrderMaster ordermaster) {
		String SQL = "INSERT INTO ordermaster(customerNumber, customerName, orderDate, orderTime, status) "
				+ "VALUES("
				+ ordermaster.getCustomerNumber()
				+ ", '"
				+ ordermaster.getOrderName()
				+ "', CURDATE(), CURTIME(), '"
				+ ordermaster.getOrderStatus().name() + "' )";
		connection = getConnection();
		boolean result = Boolean.FALSE;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;

				closeConnection();
			} else {
				System.out.println("Connection is null in addOrder");
			}
		} catch (SQLException sqle) {
			System.out.println("sqle in addOrder - " + sqle);
		}
		return result;
	}

	public int getLastOrderId() {
		String SQL = "select * from ordermaster";
		connection = getConnection();
		int orderId = 0;
		try {
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while (rs.next())
					orderId = rs.getInt("id");
			} else {
				System.out.println("Connection is null in getLastOrderId");
			}
		} catch (Exception e) {
			System.out.println("Error in getLastOrderId " + e);
		}
		return orderId;
	}

	public boolean addOrderedItems(ArrayList<OrderDetails> orderDetails) {
		for (OrderDetails ods : orderDetails) {
			if (!addOrderItem(ods))
				return false;
		}
		return true;
	}

	public boolean addOrderItem(OrderDetails ods) {
		String SQL = "INSERT INTO orderdetails(orderId, itemId, quantity, status) "
				+ "VALUES("
				+ ods.getOrderId()
				+ ", "
				+ ods.getItemId()
				+ ", "
				+ ods.getQuantity() + ", '" + ods.getOrderStatus().name()+
				"')";

		boolean result = Boolean.FALSE;
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				int update = st.executeUpdate(SQL);
				if (update > 0)
					result = Boolean.TRUE;
			} else {
				System.out
						.println("connection is null in addOrderItem(OrderDetails)");
			}
		} catch (Exception e) {
			System.out.println("Error in addOrderItem(OrderDetails) - " + e);
		}
		return result;
	}

	public ArrayList<BillDetails> getBill(int customerNumber) {
		String SQL = "SELECT orderdetails.orderId, ordermaster.customerName, item.name, item.quantity, orderdetails.quantity, item.cost"+
					" FROM orderdetails, ordermaster,item"+
					" where orderdetails.orderId = ordermaster.id and"+
					" item.itemId = orderdetails.itemId"+
					" and orderDate = curdate() and ordermaster.customerNumber="+customerNumber;	
		ArrayList<BillDetails> bdetails = new ArrayList<BillDetails>();		
		try {
			connection = getConnection();
			if (connection != null) {
				Statement st = (Statement) connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				while(rs.next())
				{
					BillDetails bd = new BillDetails();
					bd.setId(rs.getInt("orderdetails.orderId"));
					bd.setOrderId(rs.getInt("orderdetails.orderId"));
					bd.setOrderName(rs.getString("ordermaster.customerName"));
					bd.setItemName(rs.getString("item.name"));
					bd.setItemQuantity(rs.getInt("item.quantity"));
					bd.setOrderQuantity(rs.getInt("orderdetails.quantity"));
					bd.setItemCost(rs.getString("item.cost"));
					bdetails.add(bd);
					
				}
			} else {
				System.out.println("connection is null in getBill(customerNumber)");
			}
		} catch (Exception e) {
			System.out.println("Error in getBill(customerNumber) - " + e);
		}
		return bdetails;
	}

}
