package br.com.foursys.fourcamp.fourstore.service;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	public static boolean updateProduct(Product product) {

		if (ProductData.save(product)) {
			return true;
		}

		return false;
	}

	public static boolean createProduct(Product product) {

		if (ProductData.create(product)) {
			return true;
		}

		return false;
	}

	public String getList() {
		String output = "";
		output = ProductData.returnStock();
		
		if(output.equals("")) {
			return "Erro, não achei nenhum item";
		}
	
		return output;
	}

}
