package br.com.foursys.fourcamp.fourstore.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	private static final String CPF = "\\[0-9]{11}";
	private static final String CNPJ = "\\[0-9]{14}";
	private static final String CARD = "\\[0-9]{16}";
	private static final String EMAIL = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

	public boolean checkCpf(String cpf) {
		Pattern pattern = Pattern.compile(CPF);
		Matcher matcher = pattern.matcher(cpf);
		if (matcher.matches()) {
			return true;
		} else if(cpf.length() == 14) {
			return checkCnpj(cpf);
		} else {
			return false;
		}
	}

	public boolean checkCnpj(String cnpj) {
		Pattern pattern = Pattern.compile(CNPJ);
		Matcher matcher = pattern.matcher(cnpj);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkCard(String card) {		
		Pattern pattern = Pattern.compile(CARD);
		Matcher matcher = pattern.matcher(card);
		
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
