package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.next();
		System.out.println("Data de nascimento (DD/MM/YYYY):");
		Date birth_date = sdf.parse(sc.next());
		Client client = new Client(name,email,birth_date);
		System.out.println("Entre com os dados do pedido:");
		System.out.print("Status:");
		String order_status = sc.next();
		Order order = new Order(LocalDateTime.now(),OrderStatus.valueOf(order_status.toUpperCase()),client);
		System.out.print("Quantos itens tem o pedido:");
		int items_resp = sc.nextInt();
		sc.nextLine();
		for(int i = 1 ; i <= items_resp; i++){
			System.out.println("Entre com os dados do #" + i + "# pedido:");
			System.out.print("Nome do produto:");
			String product_name = sc.nextLine();
			System.out.print("Preço do produto:");
			double product_price = sc.nextDouble();
			System.out.print("Quantidade:");
			int product_quantity = sc.nextInt();
			OrderItem order_item = new OrderItem(product_quantity,product_price,new Product(product_name.toUpperCase(),product_price));
			order.addItem(order_item);
			sc.nextLine();
		}
		System.out.println();
		System.out.println("====================================================================");
		System.out.println("Informação do pedido:");
		System.out.println(order);
		System.out.println("====================================================================");
		
		sc.close();
		
		

	}

}
