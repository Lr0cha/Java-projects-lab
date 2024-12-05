package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		System.out.print("Entre com o número de contribuintes:");
		int taxPayer = sc.nextInt();
		List <TaxPayer> list = new ArrayList<>();
		for(int i = 1; i <= taxPayer; i++) {
			System.out.println("Dados do contribuinte #"+i+":");
			System.out.print("Pessoa física ou jurídica (f/j):");
			char typeTaxPayer = sc.next().charAt(0);
			System.out.print("Nome:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Renda anual:");
			double anualIncome = sc.nextDouble();
			if(Character.toUpperCase(typeTaxPayer) == 'F') {
				System.out.print("Dispesas médicas do ano:");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.print("Número de empregados:");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("Taxas pagas:");
		double totalValue = 0.0;
		for(TaxPayer payer : list) {
			System.out.println(payer);
			totalValue += payer.tax();
		}
		System.out.println();
		System.out.printf("Total de taxa: %.2f\n",totalValue);
		sc.close();
	}

}
