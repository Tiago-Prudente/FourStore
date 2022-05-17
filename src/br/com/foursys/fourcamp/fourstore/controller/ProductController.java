package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {

	public static Boolean updateQuantities(Integer sku, Integer quantity) {
		
		if(ProductService.update(sku, quantity)) {
			return true;
		}
		
		return false;
	}

}
