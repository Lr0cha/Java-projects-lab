package model.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.Exceptions.DomainException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		boolean inputValid = false;
		while(!inputValid) {
			try {
				System.out.println("ENTRE COM OS DADOS DA CONTA:");
				System.out.print("Número:");
				int number = sc.nextInt();
				sc.nextLine();
				System.out.print("Titular:");
				String holder = sc.nextLine();
				System.out.print("Saldo inicial:");
				double initialBalance = sc.nextDouble();
				System.out.print("Limite de cada saque:");
				double withdrawLimit = sc.nextDouble();
				Account acc = new Account(number, holder, initialBalance, withdrawLimit);
				System.out.println("Entre com o valor do saque (limite de " + acc.getWithdrawLimit() + "):");
				double withdraw = sc.nextDouble();
				acc.withdraw(withdraw);
				System.out.println("Novo saldo: " + acc.getBalance());
				inputValid = !inputValid;
				}
				catch(DomainException e){
					System.out.println("Erro no saque:" + e.getMessage());
					sc.next();
				}
				catch(InputMismatchException e) {
					System.out.println("Erro no que foi digitado");
					sc.next();
				}
				catch(Exception e) {
					System.out.println("Erro!");
					sc.next();
				}
				
		}
		sc.close();
		
		
		
		
		
		
		
	}

}
