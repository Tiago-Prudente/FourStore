package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;
import java.util.Date;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;
import br.com.foursys.fourcamp.fourstore.service.TransactionService;

public class TransactionController {
	TransactionService transactionS = new TransactionService();

	public String sellItemsMoney(String payMethod, ArrayList<Product> shoppingCart, String cpfBuyer) {
		String saleResult = "Algo inesperado aconteceu, tente novamente";
		Date dateOfTransaction = new Date();

		Boolean cpfCheck = cpfBuyer.length() == 11;

		String confirmMethod = confirmPayMethod(payMethod);

		if (cpfCheck) {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart, cpfBuyer);
			saleResult = transactionS.saleTransaction(transaction);
		} else {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart);
			saleResult = transactionS.saleTransaction(transaction);
		}

		return saleResult;

	}

	public String sellItemsCard(String payMethod, ArrayList<Product> shoppingCart, String cpfBuyer, String card) {
		String saleResult = "Algo inesperado aconteceu, tente novamente";
		Date dateOfTransaction = new Date();

		Boolean cpfCheck = cpfBuyer.length() == 11;

		String confirmMethod = confirmPayMethod(payMethod);
		if (cpfCheck) {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart, cpfBuyer);
			saleResult = transactionS.saleTransaction(transaction);
		} else {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart);
			saleResult = transactionS.saleTransaction(transaction);
		}
		return saleResult;
	}

	public String sellItemsPix(String payMethod, ArrayList<Product> shoppingCart, String cpfBuyer, String pix) {
		String saleResult = "Algo inesperado aconteceu, tente novamente";
		Date dateOfTransaction = new Date();

		Boolean cpfCheck = cpfBuyer.length() == 11;

		String confirmMethod = confirmPayMethod(payMethod);
		if (cpfCheck) {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart, cpfBuyer);
			saleResult = transactionS.saleTransaction(transaction);
		} else {
			Transaction transaction = new Transaction(confirmMethod, dateOfTransaction, shoppingCart);
			saleResult = transactionS.saleTransaction(transaction);
		}
		return saleResult;
	}

	private String confirmPayMethod(String payMethod) {
		if (payMethod.equals("1")) {
			return "MONEY";
		} else if (payMethod.equals("2")) {
			return "DEBITCARD";
		} else if (payMethod.equals("3")) {
			return "CREDITCARD";
		} else if (payMethod.equals("4")) {
			return "PIX";
		} else {
			return "PAGAMENTOINVALIDO";
		}
	}

	public String createCard(String cardNumber, String CVV, String monthYearExpireDate, String nameCardOwner) {
		String card = "";
		card = "Número do cartão: " + cardNumber + "/nCVV: " + CVV + "/nmês/ano vencimento: " + monthYearExpireDate
				+ "/nNome do titular do cartão: " + nameCardOwner;
		return card;
	}

	public String getAllSales() {
		String result = "";
		result = transactionS.getFromDBAllSales();
		
		return result;
	}

}
