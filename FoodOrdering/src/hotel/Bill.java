package hotel;

public class Bill {
	private int BillId;
	private int orderId;
	int totalItem;
	String totalCost;
	String orderDate;
	String orderTime;
	public int getBillId() {
		return BillId;
	}
	
	
	
	
	public Bill(int billId, int orderId, int totalItem, String totalCost, String orderDate, String orderTime) {
		super();
		BillId = billId;
		this.orderId = orderId;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}




	public void setBillId(int billId) {
		BillId = billId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
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
	@Override
	public String toString() {
		return "Bill [BillId=" + this.BillId + ", orderId=" + this.orderId + ", totalItem=" + this.totalItem + ", totalCost="
				+ this.totalCost + ", orderDate=" + this.orderDate + ", orderTime=" + this.orderTime + "]";
	}
	
	
	
	
}
