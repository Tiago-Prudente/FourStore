package br.com.foursys.fourcamp.fourstore.enums;

public enum SizeEnum {

	DEFAULT("00"),
	B20("RN"),
	B21("PP"),
	B22("P"),
	B23("M"),
	B24("G"),
	B25("GG"),
	B26("XG"),
	B27("XXG");
	
	private String size;

	SizeEnum(String string) {
		this.size = string;
	}
	
	public void setSize(String numero) {
		this.size = numero;
	}


	public String getSize() {
		return size;
	}

}
