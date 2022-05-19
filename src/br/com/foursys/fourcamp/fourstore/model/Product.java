package br.com.foursys.fourcamp.fourstore.model;

public class Product {
	private String name;
	private String description;
	private String type;
	private String size;
	private String color;
	private String category;
	private String department;
	private Integer sku;
	private Integer quantity;
	private Double price;

	
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", type=" + type + ", size=" + size
				+ ", color=" + color + ", category=" + category + ", department=" + department + ", sku=" + sku
				+ ", quantity=" + quantity + ", price=" + price + "]\n";
	}

	public Product(Integer sku, Integer quantity) {
		super();
		this.sku = sku;
		this.quantity = quantity;
	}

	public Product(String name, String description, String type, String size, String color, String category,
			String department, Integer sku, Integer quantity, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.size = size;
		this.color = color;
		this.category = category;
		this.department = department;
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDepartment() {
		return department;
	}

	public void setDeprtament(String department) {
		this.department = department;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
