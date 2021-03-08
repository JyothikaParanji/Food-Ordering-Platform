package hotel.DAO;

import java.util.ArrayList;

import hotel.BillDetails;
import hotel.Category;
import hotel.Item;
import hotel.Login;
import hotel.OrderMaster;

public class UserService
{
	
	
DBConnect dbconnect = new DBConnect();
	
	public ArrayList<Category> getAllCategory(){
		return dbconnect.getAllCategory();
	}
	public boolean checkLogin(Login login)
	{
		return  dbconnect.checkLogin(login);		
	}
	
		
	public ArrayList<Item> getAllItems(int categoryId) {
		return dbconnect.getAllItemsByCategory(categoryId);
	}
	
	
	public ArrayList<OrderMaster> getAllOrders(int customerNumber){
		return dbconnect.getAllOrders(customerNumber);
	}
	
	public ArrayList<BillDetails> getBill(int customerNumber)
	{
		return dbconnect.getBill(customerNumber);
	}
}