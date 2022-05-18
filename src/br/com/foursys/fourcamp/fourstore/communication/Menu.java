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
		System.out.println("3 - Cadastrar ou adicionar produtos");
		System.out.println("4 - Retirar o histórico de vendas do dia");
		
		MenuController.checkInputAndCallMethod();
	}

	public static void checkUpdateOrAddProduct() {
		System.out.println("Você deseja atualizar ou cadastrar um novo produto?");
		System.out.println("1 - Atualizar quantidades");
		System.out.println("2 - Cadastrar novo produto");
	}

	public static void finishedWithSucess() {
		System.out.println("Tudo certo! Solicitação OK!");
		optionsMenu();
	}

	public static void finishedWithError() {
		System.err.println("Algo inesperado aconteceu, ERRO!");
		optionsMenu();
	}

}
