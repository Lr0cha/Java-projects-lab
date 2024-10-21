/**
 * 
 */
package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Model.Entities.Contract;
import Model.Services.ContractService;
import Model.Services.PaypalService;

/**
 * 
 */
public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre os dados do contrato:");
		System.out.print("Número:");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),fmt); 
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		Contract contract = new Contract(number, date, totalValue);
		System.out.print("Entre com o numero de parcelas:");
		int months = sc.nextInt();
		ContractService contractService = new ContractService(new PaypalService());
		for(int i = 1; i <= months; i++) {
			contractService.ProcessContract(contract, i,months);
		}
		
		sc.close();
	}

}
