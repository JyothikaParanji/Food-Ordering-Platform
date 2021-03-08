package hotel;

public class Item {

	int itemId;
	int categoryId;
	String name;
	int quantity;
	String cost;
	
	public Item() {}
	

	public Item(String name, int categoryId,int quantity, String cost) {
		this.name = name;
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + this.itemId + ", categoryId=" + this.categoryId + ", name=" + this.name + ", quantity=" + this.quantity
				+ ", cost=" + this.cost + "]";
	}
	
	
	
	
}
