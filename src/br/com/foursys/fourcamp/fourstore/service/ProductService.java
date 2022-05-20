package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	ProductData productD = new ProductData();

	public boolean updateProduct(Product product) {

		if (productD.save(product)) {
			return true;
		}

		return false;
	}

	public boolean createProduct(Product product) {

		if (productD.create(product)) {
			return true;
		}

		return false;
	}

	public String getList() {
		String output = "";
		output = productD.returnStock();

		if (output.equals("")) {
			return "Erro, não achei nenhum item no estoque";
		}

		return output;
	}
	
	public ArrayList<Product> getSingleItem(ArrayList<Product> productList) {;
	ArrayList<Product> pL = new ArrayList<Product>();
	
		for (Product product : productList) {
			pL.add(productD.returnSingleItem(product));
			
		}

		return pL;
	}

	public void overloadStock(ArrayList<Product> listaProdutos) {
		for (Product product : listaProdutos) {
			createProduct(product);
		}

	}

}
