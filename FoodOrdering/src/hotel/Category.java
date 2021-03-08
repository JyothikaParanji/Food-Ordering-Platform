package hotel;

public class Category {
	int categoryId;
	String name;
	
	public Category() {}
	
	
	
	
	
	public Category(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
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



	@Override
	public String toString() {
		return "Category [categoryId=" + this.categoryId + ", name=" + this.name + "]";
	}

	

}