package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionData {
	private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	
	public String create(Transaction transaction) {
		transactionList.add(transaction);
		return "Venda adicionada com sucesso";
	}
	
	public String saleHistory() {
		String result = "";
		
		for (Transaction transaction : transactionList) {
			result += transaction.toString() + "\n";
		}
		
		if (result.equals("")) {
			result = "Não foi feita nenhuma venda ainda";
		}
		return result;
	}
}
