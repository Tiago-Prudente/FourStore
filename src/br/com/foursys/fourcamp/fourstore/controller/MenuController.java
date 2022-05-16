package br.com.foursys.fourcamp.fourstore.controller;

import java.util.Scanner;

public class MenuController {
	Scanner sc = new Scanner(System.in);

	public static void checkInputAndCallMethod() {
		Integer option = -1;

		do {
			switch (option) {
			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			default:
				option = -1;
				throw new IllegalArgumentException("Opção invalida, tente novamente");
			}

		} while (option != -1);

	}

}
