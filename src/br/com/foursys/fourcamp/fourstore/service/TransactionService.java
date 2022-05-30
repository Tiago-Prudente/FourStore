package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.TransactionData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionService {
	ProductService productS = new ProductService();
	TransactionData transactionD = new TransactionData();
	
	public String saleTransaction(Transaction transaction) {
		String result = "Ok";
		ArrayList<Product> productList = new ArrayList<Product>();
		
		for(int i = 0; i < transaction.getProduct().size(); i++) {
			productList = productS.getSingleItem(transaction.getProduct());
			transaction.getProduct().remove(i);
			transaction.getProduct().add(i, productList.get(i));
		}

		System.out.println(transaction);
		
		transactionD.create(transaction);
		return result;
	}

	public String getFromDBAllSales() {
		String result = "";
		
		if (result.equals("")) {
			result = "Não foi feita nenhuma venda ainda";
		}
		
		result = transactionD.saleHistory();
		return result;
	}

}
