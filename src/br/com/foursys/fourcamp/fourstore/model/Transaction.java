package br.com.foursys.fourcamp.fourstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethods;

public class Transaction {

	private String transactionId;
	private PaymentMethods paymentMethod;
	private Date dateOfTransaction;
	private List<Product> productList = new ArrayList<Product>();
	
	public Transaction(String transactionId, PaymentMethods paymentMethod, Date dateOfTransaction) {
		super();
		this.transactionId = transactionId;
		this.paymentMethod = paymentMethod;
		this.dateOfTransaction = dateOfTransaction;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public PaymentMethods getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethods paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}
