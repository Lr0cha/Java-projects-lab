package Model.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Entities.Contract;
import Model.Entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}


	public void ProcessContract(Contract contract, int i,int months) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		double value = contract.getTotalValue()/months; //valor cada parcela sem taxas
		double installmentValue = onlinePaymentService.interest(value, i);
		double newInstallmentValue = onlinePaymentService.paymentFee(installmentValue);
			
		LocalDate dueDate = contract.getDate().plusMonths(i) ;
		contract.addList(new Installment(dueDate,newInstallmentValue));
		System.out.println("Parcela" + i + ":");
		System.out.print("Dia:" + dueDate.format(fmt) + "   ");
		System.out.println("Valor: " + newInstallmentValue);
	}
	
}
