package hotel;


public class OrderMaster {
	int id;	
	int customerNumber;
	String orderDate;
	String orderTime;
	public enum OrderStatus { JUST_ORDERED, IN_PROCESS, COOKED, DELIVERED }
	public OrderStatus orderStatus;
	
	String orderName ;
	
	
	

	public OrderMaster(int id, int customerNumber, String orderDate, String orderTime, OrderStatus orderStatus,
			String orderName) {
		super();
		this.id = id;
		this.customerNumber = customerNumber;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.orderName = orderName;
	}

	public OrderMaster() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "OrderMaster [id=" + this.id + ", customerNumber=" + this.customerNumber + ", orderDate=" + this.orderDate
				+ ", orderTime=" + this.orderTime + ", orderStatus=" + this.orderStatus + ", orderName=" + this.orderName + "]";
	}
	
}
