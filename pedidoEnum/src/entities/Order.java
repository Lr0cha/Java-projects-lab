/**
 * 
 */
package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

/**
 * 
 */
public class Order {
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> order_item = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getOrder_item() {
		return order_item;
	}
	public void addItem(OrderItem item) {
		order_item.add(item);
	}
	public void RemoveItem(OrderItem item) {
		order_item.remove(item);
	}
	public double total(){
		double total = 0.0;
		for(OrderItem item : order_item) {
			total += item.subTotal();
		}
		return total;
	}
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido:" + moment.format(format) + "\n");
		sb.append("Status do pedido:" + status + "\n");
		for(OrderItem item : order_item) {
			sb.append(item + "\n");
		}
		sb.append("Total final:\n");
		sb.append("R$" + this.total());
		return sb.toString();
	}
}

