package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com a quantidade de produtos:");
		int num_products = sc.nextInt();
		List <Product> products = new ArrayList<>();
		for(int i = 0; i < num_products; i++) {
			System.out.println("Dados do produto #"+(i+1)+":");
			System.out.print("Comum, usado ou importado (c/u/i)?");
			char resp = sc.next().charAt(0);
			System.out.print("Nome:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço:");
			Double price = sc.nextDouble();
			if(resp == 'c' || resp == 'C') {
				products.add(new Product(name, price));
			}
			else if(resp == 'u' || resp == 'U') {
				System.out.print("Data de fabricação:(DD/MM/YYYY)");
				LocalDate date = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
				products.add(new UsedProduct(name,price,date));
			}else {
				System.out.print("Taxa:");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			}
		}
		System.out.println("Produtos registrados com sucesso!");
		System.out.println();
		System.out.println("Lista de produtos:");
		for(Product prod : products) {
			System.out.println(prod.priceTag());;
		}
		sc.close();
	}

}
