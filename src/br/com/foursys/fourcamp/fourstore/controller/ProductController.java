package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {

	public Boolean updateQuantities(Integer sku, Integer quantity) {
		Product product = new Product(sku, quantity);
		if(ProductService.updateProduct(product)) {
			return true;
		}
		
		return false;
	}

	public Boolean createProduct(String name, String description, String type, String size, String color,
			String category, String department, Integer sku, Integer quantity, Double price) {
		Product product = new Product(name, description, type, size, color, category, department, sku, quantity, price);
		if(ProductService.createProduct(product)) {
			return true;
		}
				
				
				
		return false;
	}

	public String getList() {
		String output = "";
		ProductService productS = new ProductService();
		output = productS.getList();
		
		return output;
	}

	public void sellItems(String itemName, String itemQuantity) {
		
		System.out.println(itemName + itemQuantity);
		
	}

}
