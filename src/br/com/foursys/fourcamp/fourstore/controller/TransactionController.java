package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;
import java.util.Date;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Transaction;
import br.com.foursys.fourcamp.fourstore.service.TransactionService;
import br.com.foursys.fourcamp.fourstore.util.Validate;

public class TransactionController {
	TransactionService transactionS = new TransactionService();
	Validate validator = new Validate();

	public String sellItems(String payMethod, ArrayList<Product> shoppingCart, String cpfBuyer, String payDetails) {
		String saleResult = "Algo inesperado aconteceu, tente novamente";
		Date dateOfTransaction = new Date();

		Boolean cpfCheck = validator.checkCpf(cpfBuyer);

		String confirmMethod = confirmPayMethod(payMethod);

		if(shoppingCart != null) {
			if (cpfCheck) {
				Transaction transaction = new Transaction(confirmMethod, payDetails, dateOfTransaction, shoppingCart,
						cpfBuyer);
				saleResult = transactionS.saleTransaction(transaction);
			} else {
				Transaction transaction = new Transaction(confirmMethod, payDetails, dateOfTransaction, shoppingCart);
				saleResult = transactionS.saleTransaction(transaction);
			}
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
		if(validator.checkCard(cardNumber)) {
		card = "Número do cartão: " + cardNumber + "/nCVV: " + CVV + "/nmês/ano vencimento: " + monthYearExpireDate
				+ "/nNome do titular do cartão: " + nameCardOwner;
		return card;
	} else {
		card = "ERRO - CARTÃO COM A MENOS OU MAIS DE 16 DÍGITOS";
	}
		return card;
	}

	public String getAllSales() {
		String result = "";
		result = transactionS.getFromDBAllSales();

		return result;
	}

}
