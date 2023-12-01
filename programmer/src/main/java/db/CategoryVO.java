package db;

public class CategoryVO {
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		this.CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		this.CategoryName = categoryName;
	}
	private int CategoryId;
	private String CategoryName;
}
