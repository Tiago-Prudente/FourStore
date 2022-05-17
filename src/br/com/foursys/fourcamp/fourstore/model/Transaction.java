package br.com.foursys.fourcamp.fourstore.model;

import java.util.Date;
import java.util.UUID;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethods;

public class Transaction {

	private UUID transactionID;
	private PaymentMethods paymentMethod;
	private Date transactionDate;
	private Product product;

	public Transaction(UUID transactionID, PaymentMethods paymentMethod, Date transactionDate, Product product) {
		this.transactionID = UUID.randomUUID();
		this.paymentMethod = paymentMethod;
		this.transactionDate = transactionDate;
		this.product = product;
	}

	public UUID getTransactionID() {
		return transactionID;
	}

	public PaymentMethods getPaymentMethod() {
		return paymentMethod;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
