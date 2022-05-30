package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductData {
	private static ArrayList<Product> productList = new ArrayList<Product>();

	public boolean create(Product product) {
		if (!iterateList(product)) {
			productList.add(product);
			return true;
		} else {
			return false;
		}
	}

	public String returnStock() {
		String output = "";

		for (Product product : productList) {
			output += product.toString();
		}
		return output;
	}

	public boolean save(Product product) {
		Boolean foundInList = false;
		foundInList = iterateList(product);
		if (foundInList) {
			for (int i = 0; i < productList.size(); i++) {
				productList.get(i).setQuantity(productList.get(i).getQuantity() + product.getQuantity());
			}
		}

		return foundInList;
	}

	public String delete(Product product) {
		String result = "Erro, não encontrei o produto no estoque";
		Boolean foundInList = false;
		foundInList = iterateList(product);
		if (foundInList) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getQuantity() - product.getQuantity() >= 0) {
					productList.get(i).setQuantity(productList.get(i).getQuantity() - product.getQuantity());
					result = "Item removido";
				} else {
					result = "Erro, quantidade para remoção maior do que tem no estoque";
				}
			}
		}

		return result;
	}

	private boolean iterateList(Product product) {
		for (Product item : productList) {
			if (item.getSku().equals(product.getSku())) {
				return true;
			}
		}
		return false;
	}

	public Product returnSingleItem(Product transactionProd) {
		for (Product product : productList) {
			if (product.getSku().equals(transactionProd.getSku())) {
				if (delete(product).equals("Item removido"))
					product.setQuantity(transactionProd.getQuantity());
				return product;
			}
		}
		return null;
	}

}
