package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.TransactionData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionService {
	ProductService productS = new ProductService();
	TransactionData transactionD = new TransactionData();

	public String saleTransaction(Transaction transaction) {
		String result = "";
		ArrayList<Product> productList = new ArrayList<Product>();

		for (int i = 0; i < transaction.getProduct().size(); i++) {
			productList = productS.getSingleItem(transaction.getProduct());
			transaction.getProduct().remove(i);
			transaction.getProduct().add(i, productList.get(i));
		}

		result = transactionD.create(transaction);
		
		if(result == null) {
			result = "ERRO - TRANSAÇÃO INVALIDA";
		}
		
		return result;
	}

	public String getFromDBAllSales() {
		String result = "";
		result = transactionD.saleHistory();
		
		if (result.equals("")) {
			result = "Não foi feita nenhuma venda ainda";
		}

		return result;
	}

}
