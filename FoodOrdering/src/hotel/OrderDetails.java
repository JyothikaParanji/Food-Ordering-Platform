package hotel;

public class OrderDetails {
	
	int id;
	int orderId;
	int itemId;
	int quantity;
	String status;
	int customerNumber;
	String cost;
	String name;
	int categoryId;
	
	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public enum OrderStatus { STARTED, IN_PROCESS, COOKED }
	public OrderStatus orderStatus;
	
	public OrderDetails() {
		
	}

	
	public OrderDetails(int id, int orderId, int itemId, int quantity, String status, int customerNumber, String cost,
			String name, int categoryId, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.status = status;
		this.customerNumber = customerNumber;
		this.cost = cost;
		this.name = name;
		this.categoryId = categoryId;
		this.orderStatus = orderStatus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String string) {
		this.cost = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public  static OrderStatus getOrderStatus(String orderStatus ) {
		for(OrderStatus os : OrderStatus.values())
		{
			if(os.name().equals(orderStatus))
				return os;
		}
		return null;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}



	@Override
	public String toString() {
		return "OrderDetails [id=" + this.id + ", orderId=" + this.orderId + ", itemId=" + this.itemId + ", quantity=" + this.quantity
				+ ", status=" + this.status + ", customerNumber=" + this.customerNumber + ", cost=" + this.cost + ", name=" + this.name
				+ ", categoryId=" + this.categoryId + ", orderStatus=" + this.orderStatus + "]";
	}

	


}


	
	


