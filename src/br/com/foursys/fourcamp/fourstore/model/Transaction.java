package br.com.foursys.fourcamp.fourstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethodsEnum;

public class Transaction {

	private UUID transactionID;
	private PaymentMethodsEnum paymentMethod;
	private Date transactionDate;
	private ArrayList<Product> product;
	private String cpf;

	@Override
	public String toString() {
		return "Transação ID: " + transactionID 
				+ "\nMétodo de Pagamento: " + paymentMethod.getDescription() 
				+ "\nData da transação: " + transactionDate 
				+ "\nProduto: " + product 
				+ "\nCpf Comprador: " + cpf 
				+ "\n";
	}

	public Transaction(String paymentMethod, Date transactionDate, ArrayList<Product> product) {
		this.transactionID = UUID.randomUUID();
		this.paymentMethod = PaymentMethodsEnum.valueOf(paymentMethod);
		this.transactionDate = transactionDate;
		this.product = product;
		this.cpf = "0";
	}

	public Transaction(String paymentMethod, Date transactionDate, ArrayList<Product> product,	String cpf) {
		super();
		this.transactionID = UUID.randomUUID();
		this.paymentMethod = PaymentMethodsEnum.valueOf(paymentMethod);
		this.transactionDate = transactionDate;
		this.product = product;
		this.cpf = cpf;
	}

	public UUID getTransactionID() {
		return transactionID;
	}

	public PaymentMethodsEnum getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethodsEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
