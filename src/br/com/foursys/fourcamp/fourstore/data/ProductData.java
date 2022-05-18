package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData {
	ArrayList<Product> productList = new ArrayList<Product>();

	public boolean save(Product product) {
		Boolean foundInList = false;
		foundInList = iterateList(product);
		if (foundInList) {
			updateListAddStock(product);
		}

		return foundInList;
	}

	private void updateListAddStock(Product product) {
		for (int i = 0; i <= productList.size(); i++) {
			productList.get(i).setQuantity(productList.get(i).getQuantity() + product.getQuantity());
		}

	}

	private boolean iterateList(Product product) {
		for (Product item : productList) {
			if (item.getSku() == product.getSku()) {
				return true;
			}
		}
		return false;
	}

}
