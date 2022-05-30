package br.com.foursys.fourcamp.fourstore.communication;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.controller.TransactionController;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class Menu {
	public static void initializeSystem() {

		System.out.println("Bem vindo ao sistema da FourStore");
		optionsMenu();

	}

	public static void optionsMenu() {
		System.out.println("Digite a opção desejada.");
		System.out.println("1 - Vender produtos");
		System.out.println("2 - Conferir estoque");
		System.out.println("3 - Cadastrar ou adicionar produtos");
		System.out.println("4 - Retirar o histórico de vendas do dia");
		System.out.println("99 - Sobrecarregar o estoque");
		System.out.println("0 - Fechar sistema");

		checkInputAndCallMethod();
	}

	public static void checkInputAndCallMethod() {
		ProductController productC = new ProductController();
		TransactionController transactionC = new TransactionController();
		Scanner sc = new Scanner(System.in);
		Integer option = -1, opt = 0;
		Integer input;

		option = sc.nextInt();
		do {
			switch (option) {
			case 0: // sair do programa
				System.exit(0);
				break;

			case 1: // Vender um ou mais produtos
				ArrayList<Product> shoppingCart = new ArrayList<Product>();
				String saleResult = "";
				do {
					System.out.println(sc.nextLine());
					System.out.println("O que você quer comprar, digite o sku");
					String itemSku = sc.nextLine();
					System.out.println("Digite a quantidade");
					Integer itemQuantity = sc.nextInt();
					Product product = new Product(itemSku, itemQuantity);
					shoppingCart.add(product);
					System.out.println("Deseja comprar mais, digite 1");
					System.out.println("Se deseja continuar digite 2");

					opt = sc.nextInt();
				} while (opt.equals(1));
				sc.nextLine();
				System.out.println("Informe o meio de pagamento");
				System.out.println("1 - Dinheiro");
				System.out.println("2 - Cartão de débito");
				System.out.println("3 - Cartão de crédito");
				System.out.println("4 - Pix");
				String payMethod = sc.nextLine();
				
				System.out.println("Informe o CPF sem pontos ou traços, caso não queira digite 0");
				String cpfBuyer = "0";
				cpfBuyer = sc.nextLine();
				
				if (payMethod.equals("2") || payMethod.equals("3")) {
					System.out.println("Digite Número do cartão de crédito");
					String cardNumber = sc.nextLine();
					System.out.println("Código CVV");
					String CVV = sc.nextLine();
					System.out.println("Mês e ano de vencimento. mm/yy");
					String monthYearExpireDate = sc.nextLine();
					System.out.println("Nome do titular do cartão");
					String nameCardOwner = sc.nextLine();
					String card = transactionC.createCard(cardNumber, CVV, monthYearExpireDate, nameCardOwner);
					saleResult = transactionC.sellItemsCard(payMethod, shoppingCart, cpfBuyer, card);

				} else if (payMethod.equals("4")) {
					System.out.println("Informe a chave pix");
					String pixKey = sc.nextLine();
					saleResult = transactionC.sellItemsPix(payMethod, shoppingCart, cpfBuyer, pixKey);
					
				} else {
					saleResult = transactionC.sellItemsMoney(payMethod, shoppingCart, cpfBuyer);
					
				}


				System.out.println(saleResult);

				Menu.optionsMenu();
				break;

			case 2: // Conferir estoque
				System.out.println("O estoque atual é: ");
				String stockOutput = productC.getList();

				System.out.println(stockOutput);
				Menu.optionsMenu();
				break;

			case 3: // Cadastrar ou atualizar produtos
				Menu.checkUpdateOrAddProduct();
				input = sc.nextInt();
				if (input == 1) {
					System.out.println("Digite o sku do produto");
					String sku = sc.nextLine();
					System.out.println("Digite a quantidade");
					Integer quantity = sc.nextInt();

					Boolean returnInfo = productC.updateQuantities(sku, quantity);
					if (returnInfo) {
						Menu.finishedWithSucess();
					} else {
						Menu.finishedWithError();
					}
				} else if (input == 2) {
					String description, sku;
					Integer quantity;
					Double price;
					sc.nextLine();
					System.out.println("Digite a descrição do produto");
					description = sc.nextLine();
					System.out.println("Digite o Sku");
					sku = sc.nextLine();
					System.out.println("Digite a quantidade inicial");
					quantity = sc.nextInt();
					System.out.println("Digite o preço");
					price = sc.nextDouble();

					Boolean returnInfo = productC.createProduct(description, sku, quantity, price);
					if (returnInfo) {
						Menu.finishedWithSucess();
					} else {
						Menu.finishedWithError();
					}

				} else {
					System.err.println("Erro, valor errado. Tente novamente.");
				}
				break;

			case 4: // Histórico de vendas do dia
				String salesResult = "";
				salesResult = transactionC.getAllSales();
				System.out.println(salesResult);
				optionsMenu();
				break;

			case 99:
				String createSystem = "";
				System.out.println("Preenchendo o sistema.");
				createSystem = productC.overloadSystem();
				System.out.println(createSystem);
				optionsMenu();
				break;

			default:
				System.out.println("Opção invalida, tente novamente\n");
				optionsMenu();
			}
			sc.close();
		} while (option != 0);
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
