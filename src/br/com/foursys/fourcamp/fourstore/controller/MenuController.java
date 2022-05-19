package br.com.foursys.fourcamp.fourstore.controller;

import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.communication.Menu;

public class MenuController {

	public static void checkInputAndCallMethod() {
		Scanner sc = new Scanner(System.in);
		Integer option = -1, opt = 0;
		Integer input;
		String itemName = "", itemQuantity = "";
		option = sc.nextInt();
		do {
			switch (option) {
			case 0: // sair do programa
				System.exit(0);
				break;

			case 1: // Vender um ou mais produtos
				do {
					System.out.println(sc.nextLine());
					System.out.println("O que você quer comprar, digite o nome");
					itemName += sc.nextLine();
					itemName += "\n";
					System.out.println("Digite a quantidade");
					itemQuantity += sc.nextLine();
					itemQuantity += "\n";
					System.out.println("Deseja comprar mais, digite 1");
					System.out.println("Se deseja continuar digite qualquer coisa");
					
					opt = sc.nextInt();
				} while (opt.equals(1));

				ProductController productSell = new ProductController();
				productSell.sellItems(itemName, itemQuantity);

				Menu.optionsMenu();
				break;

			case 2: // Conferir estoque
				System.out.println("O estoque atual é: ");
				ProductController productGet = new ProductController();
				String stockOutput = productGet.getList();

				System.out.println(stockOutput);
				Menu.optionsMenu();
				break;

			case 3: // Cadastrar ou atualizar produtos
				Menu.checkUpdateOrAddProduct();
				input = sc.nextInt();
				if (input == 1) {
					Integer sku, quantity;
					System.out.println("Digite o sku do produto");
					sku = sc.nextInt();
					System.out.println("Digite a quantidade");
					quantity = sc.nextInt();

					ProductController productC = new ProductController();
					Boolean returnInfo = productC.updateQuantities(sku, quantity);
					if (returnInfo) {
						Menu.finishedWithSucess();
					} else {
						Menu.finishedWithError();
					}
				} else if (input == 2) {
					String name, description, type, size, color, category, department;
					Integer sku, quantity;
					Double price;
					sc.nextLine();
					System.out.println("Digite o nome do produto");
					name = sc.nextLine();
					System.out.println("Digite a descrição do produto");
					description = sc.nextLine();
					System.out.println("Digite o tipo do produto");
					type = sc.nextLine();
					System.out.println("Digite o tamanho do produto");
					size = sc.nextLine();
					System.out.println("Digite a cor do produto");
					color = sc.nextLine();
					System.out.println("Digite a categoria");
					category = sc.nextLine();
					System.out.println("Digite o departamento");
					department = sc.nextLine();
					System.out.println("Digite o Sku");
					sku = sc.nextInt();
					System.out.println("Digite a quantidade inicial");
					quantity = sc.nextInt();
					System.out.println("Digite o preço");
					price = sc.nextDouble();

					ProductController productC = new ProductController();
					Boolean returnInfo = productC.createProduct(name, description, type, size, color, category,
							department, sku, quantity, price);
					if (returnInfo) {
						Menu.finishedWithSucess();
					} else {
						Menu.finishedWithError();
					}

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

		} while (option != 0);

		sc.close();
	}

}
