package br.com.foursys.fourcamp.fourstore.enums;

public enum DepartmentEnum {
	DEFAULT("00"),
	E50("VESTUARIO"),
	E51("CALCADOS"),
	E52("PERFUMARIA"),
	E53("ACESSORIOS");

	private String department;
	
	DepartmentEnum(String string) {
		this.department = string;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
