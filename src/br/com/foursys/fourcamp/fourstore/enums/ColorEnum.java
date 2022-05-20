package br.com.foursys.fourcamp.fourstore.enums;

public enum ColorEnum {
	DEFAULT("00"),
	F60("VERMELHO"),
	F61("VERDE"),
	F62("AZUL"),
	F63("BRANCO"),
	F64("PRETO"),
	F65("AMARELO"),
	F66("MARROM"),
	F67("CINZA");

	private String color;
	
	ColorEnum(String string) {
		this.color = string;
	}

	public String getColor() {
		return color;
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	
}
