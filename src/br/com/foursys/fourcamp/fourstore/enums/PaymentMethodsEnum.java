package br.com.foursys.fourcamp.fourstore.enums;

public enum PaymentMethodsEnum {

	MONEY("Dinheiro à vista"),
	DEBITCARD("Cartão de Débito"),
	CREDITCARD("Cartao de Crédito"),
	PIX("Pix"),
	PAGAMENTOINVALIDO("Pagamento Invalido");

	private String description;

	PaymentMethodsEnum(String string) {
		this.description = string;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
