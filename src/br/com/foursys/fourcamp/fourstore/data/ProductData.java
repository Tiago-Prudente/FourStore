package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData {
	static ArrayList<Product> productList = new ArrayList<Product>();

	public static boolean save(Product product) {
		Boolean foundInList = false;
		foundInList = iterateList(product);
		if (foundInList) {
			updateListAddStock(product);
		}

		return foundInList;
	}

	private static void updateListAddStock(Product product) {
		for (int i = 0; i < productList.size(); i++) {
			if(iterateList(product)){
				productList.get(i).setQuantity(productList.get(i).getQuantity() + product.getQuantity());	
			}
		
		}

	}

	private static boolean iterateList(Product product) {
		for (Product item : productList) {
			if (item.getSku().equals(product.getSku())) {
				return true;
			}
		}
		return false;
	}

	public static boolean create(Product product) {
		productList.add(product);
		return true;
	}

	public static String returnStock() {
		String output = "";
		
		for (Product product : productList) {
			output += product.toString();
		}
		
		return output;
	}

}
