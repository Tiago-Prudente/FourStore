package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	public static boolean update(Integer sku, Integer quantity) {
		Product product = new Product(sku, quantity);
		ProductData productData = new ProductData();
		
		if(productData.save(product)) {
			return true;
		}
		
		return false;
	}

}
