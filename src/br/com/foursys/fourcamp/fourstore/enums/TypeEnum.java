package br.com.foursys.fourcamp.fourstore.enums;

public enum TypeEnum {
	DEFAULT("00"),
	D40("VERAO"),
	D41("INVERNO"),
	D42("OUTONO"),
	D43("PRIMAVERA"),
	D44("OUTROS");

	private String type;
	
	TypeEnum(String string) {
		this.type = string;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
