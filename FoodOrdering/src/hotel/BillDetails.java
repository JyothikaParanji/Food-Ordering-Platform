package hotel;

public class BillDetails {
	int id;
	int orderId;
	int customerNumber;
	String orderName;
	String itemName;
	int itemQuantity;
	int orderQuantity;
	String itemCost;
	
	public BillDetails() {
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

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getItemCost() {
		return itemCost;
	}

	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}

	
	
	@Override
	public String toString() {
		return " OrderMaster {id=" + this.id + ", orderId=" + this.orderId
				+ ", orderName=" + this.orderName + ", itemName="
				+ this.itemName + ", itemQuantity=" + this.itemQuantity + ", orderQuantity="
				+ this.orderQuantity + ", itemCost=" + this.itemCost + " }";
	}
	
	}
	
	

	