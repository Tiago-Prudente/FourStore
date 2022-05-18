package br.com.foursys.fourcamp.fourstore.controller;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.communication.Menu;

public class MenuController {

	public static void checkInputAndCallMethod() {
		Scanner sc = new Scanner(System.in);
		Integer option = -1;
		Integer input;
		option = sc.nextInt();
		do {
			switch (option) {
			case 0: // sair do programa
				System.exit(0);
				break;
				
			case 1: // Vender um ou mais produtos

				break;

			case 2: // Conferir estoque

				break;

			case 3: // Cadastrar ou atualizar produtos
				Menu.checkUpdateOrAddProduct();
				input = sc.nextInt();
				if(input == 1) {
					Integer sku, quantity;
					System.out.println("Digite o sku do produto");
					sku = sc.nextInt();
					System.out.println("Digite a quantidade");
					quantity = sc.nextInt();
					
					ProductController productC = new ProductController();
					Boolean returnInfo = productC.updateQuantities(sku, quantity);
					if(returnInfo) {
						Menu.finishedWithSucess();
					} else {
						Menu.finishedWithError();
					}
				} else if(input == 2) {
					String name, description, type, size, color, category, departament; 
					Integer sku, quantity;
					Double price;
				} else {
					System.err.println("Erro, valor errado. Tente novamente."); 
				}
				break;

			case 4: // Histórico do dia

				break;

			default:
				option = -1;
				throw new IllegalArgumentException("Opção invalida, tente novamente");
			}

		} while (option != -1);
		
		sc.close();
	}

}
