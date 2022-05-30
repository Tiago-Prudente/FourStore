package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Transaction;

public class TransactionData {
	private static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	public String create(Transaction transaction) {

		if (!transactionList.isEmpty()) {
			for (Transaction item : transactionList) { // Check if the Sell ID is duplicated.
				if (item.getTransactionID().equals(transaction.getTransactionID())) {
					return "Transação repetida, não foi possível continuar.";
				}
			}
		}

		transactionList.add(transaction);
		return "Venda adicionada com sucesso";

	}

	public String saleHistory() {
		String result = "";

		for (Transaction transaction : transactionList) {
			result += transaction.toString() + "\n";
		}

		return result;
	}
}
