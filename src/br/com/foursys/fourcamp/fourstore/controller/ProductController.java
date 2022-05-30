package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.service.ProductService;

public class ProductController {
	ProductService productS = new ProductService();

	public String getList() {
		String output = "";
		output = productS.getList();
		return output;
	}

	public String updateQuantities(String sku, Integer quantity) {
		Product product = new Product(sku, quantity);
		return productS.updateProduct(product);
	}

	public String createProduct(String description, String sku, Integer quantity, Double price) {
		Product product = new Product(description, sku, quantity, price);
		String result = productS.createProduct(product);
		return result;
	}

	public String overloadSystem() {

		if (getList().equals("Erro, não achei nenhum item no estoque")) {
			ArrayList<Product> listaProdutos = new ArrayList<Product>();
			Product productA = new Product("A", "A01B20C30D40E50F60", 20, 30.50);
			Product productB = new Product("B", "A02B21C31D41E51F61", 17, 20.75);
			Product productC = new Product("C", "A03B22C32D42E52F62", 22, 15.0);
			Product productD = new Product("D", "A04B23C30D43E53F63", 7, 12.32);
			Product productE = new Product("E", "A05B24C31D44E50F64", 4, 25.12);
			Product productF = new Product("F", "A06B25C32D40E51F65", 32, 66.71);
			Product productG = new Product("G", "A07B26C30D41E52F66", 6, 76.50);
			Product productH = new Product("H", "A08B27C31D42E53F67", 4, 54.33);
			Product productI = new Product("I", "A09B20C32D43E50F60", 3, 34.22);
			Product productJ = new Product("J", "A10B21C30D44E51F61", 12, 32.50);

			listaProdutos.add(productA);
			listaProdutos.add(productB);
			listaProdutos.add(productC);
			listaProdutos.add(productD);
			listaProdutos.add(productE);
			listaProdutos.add(productF);
			listaProdutos.add(productG);
			listaProdutos.add(productH);
			listaProdutos.add(productI);
			listaProdutos.add(productJ);

			productS.overloadStock(listaProdutos);
			return "Estoque preenchido com sucesso!";
		}

		return "Erro, estoque já preenchido!";
	}

}
