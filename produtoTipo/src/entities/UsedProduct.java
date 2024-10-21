package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manufactureDate;
	
	public UsedProduct() {
		super();
	}
	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	@Override
	public String priceTag() {
		StringBuilder sc = new StringBuilder();
		sc.append(getName()).append(" (used) ");
		sc.append(String.format("%.2f", getPrice()));
		sc.append(" (Manufacture date: " + manufactureDate.format(format)).append(")");
		return sc.toString();
		
	}
}
