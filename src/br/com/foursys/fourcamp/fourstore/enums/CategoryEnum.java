package br.com.foursys.fourcamp.fourstore.enums;

public enum CategoryEnum {
	C30("MS"),
	C31("FM"),
	C32("BB"), 
	DEFAULT("00");
	
	private String category;
	
	CategoryEnum(String string) {
		this.category = string;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
