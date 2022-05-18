package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {

	public Boolean updateQuantities(Integer sku, Integer quantity) {
		Product product = new Product(sku, quantity);
		if(ProductService.update(product)) {
			return true;
		}
		
		return false;
	}

}
