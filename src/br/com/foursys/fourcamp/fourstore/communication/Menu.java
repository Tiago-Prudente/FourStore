package br.com.foursys.fourcamp.fourstore.communication;

import br.com.foursys.fourcamp.fourstore.controller.MenuController;

public class Menu {

	public static void initializeSystem() {
		
		System.out.println("Bem vindo ao sistema da FourStore");
		optionsMenu();
		
	}

	private static void optionsMenu() {
		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Vender um produto");
		System.out.println("2 - Conferir estoque");
		System.out.println("3 - Adicionar novo produto");
		System.out.println("4 - Retirar o histórico de vendas do dia");
		
		MenuController.checkInputAndCallMethod();
	}

}
