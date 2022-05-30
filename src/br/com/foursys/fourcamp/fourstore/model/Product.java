package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.CategoryEnum;
import br.com.foursys.fourcamp.fourstore.enums.ColorEnum;
import br.com.foursys.fourcamp.fourstore.enums.DepartmentEnum;
import br.com.foursys.fourcamp.fourstore.enums.NameEnum;
import br.com.foursys.fourcamp.fourstore.enums.SizeEnum;
import br.com.foursys.fourcamp.fourstore.enums.TypeEnum;

public class Product {
	private NameEnum name;
	private String description;
	private TypeEnum type;
	private SizeEnum size;
	private ColorEnum color;
	private CategoryEnum category;
	private DepartmentEnum department;
	private String sku;
	private Integer quantity;
	private Double price;

	@Override
	public String toString() {
		return "\nProduto nome: " + name.getName() + "\nDescrição: " + description + "\nTipo: " + type.getType()
				+ "\nTamanho: " + size.getSize() + "\nCor: " + color.getColor() + "\nCategoria: "
				+ category.getCategory() + "\nDepartamento: " + department.getDepartment() + "\nSku: " + sku
				+ "\nQuantidade: " + quantity + "\nPreço: R$" + price + "\n";
	}

	public Product(String sku, Integer quantity) {
		super();
		this.sku = sku;
		this.quantity = quantity;
		skuParse(sku);
	}

	public Product(String description, String sku, Integer quantity, Double price) {
		super();
		this.description = description;
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		skuParse(sku);
	}

	public NameEnum getName() {
		return name;
	}

	public void setName(NameEnum name) {
		this.name = name;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public SizeEnum getSize() {
		return size;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public ColorEnum getColor() {
		return color;
	}

	public void setColor(ColorEnum color) {
		this.color = color;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public DepartmentEnum getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	private void skuParse(String skuToParse) {
		try {
			String name, size, category, type, department, color;

			name = skuToParse.substring(0, 3);
			size = skuToParse.substring(3, 6);
			category = skuToParse.substring(6, 9);
			type = skuToParse.substring(9, 12);
			department = skuToParse.substring(12, 15);
			color = skuToParse.substring(15, 18);

			NameEnum nameEnum = NameEnum.valueOf(name);
			SizeEnum sizeEnum = SizeEnum.valueOf(size);
			CategoryEnum categoryEnum = CategoryEnum.valueOf(category);
			TypeEnum typeEnum = TypeEnum.valueOf(type);
			DepartmentEnum departmentEnum = DepartmentEnum.valueOf(department);
			ColorEnum colorEnum = ColorEnum.valueOf(color);

			this.name = nameEnum;
			this.size = sizeEnum;
			this.category = categoryEnum;
			this.type = typeEnum;
			this.department = departmentEnum;
			this.color = colorEnum;
		} catch (Exception e) {
			System.err.println("ERROR, SKU INVALIDO " + e);
		}

	}
}
