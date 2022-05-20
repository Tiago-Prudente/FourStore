package br.com.foursys.fourcamp.fourstore.enums;

public enum NameEnum {
	A01("CAMISA"),
	A02("CAMISETA"),
	A03("CALCA"),
	A04("BERMUDA"),
	A05("CUECA"),
	A06("CALCINHA"),
	A07("SUTIA"),
	A08("TENIS"),
	A09("CHINELO"),
	A10("VESTIDO"),
	DEFAULT("DEFAULT");

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	NameEnum(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

}
