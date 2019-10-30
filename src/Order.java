import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 *
 */

enum OrderStatus {
	New, Hold, Shipped, Delivered, Closed;
}

public class Order {
	private String number;
	private Date ordered;
	private Date shipped;
	private Address ship_to;
	private OrderStatus status;
	private double total;
	private LineItem[] line_items;
	private int orderSize;
	private Payment[] payments;
	private int paymentsSize;
	
	private static long idCounter = 0;
	public static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}   
	
	public Order() {
		number = createID();
		ordered = new Date();
		status = OrderStatus.New;
		orderSize = 0;
		line_items = new LineItem[100];
		payments = new Payment[100];
	}
	
	public void addLineItem(LineItem item) {
		line_items[orderSize] = item;
		orderSize++;
		total += item.getTotal();
	}
	
	public void addPayment(Payment payment) {
		payments[paymentsSize] = payment;
		paymentsSize++;
	}
	
	public void convertCartToOrder(Account account) {
		ShoppingCart cart = account.getCart();
		ship_to = account.getBillingAddress();
		for(int i=0; i<cart.getSize(); i++) {
			addLineItem(cart.getItems()[i]);
		}
	}
	
	public String toString() {
		String out = "Order Number " + number + "\nStatus: " + status + "\nShpping Address: " + ship_to + "\nTotal: " + total + "\n";
		for(int i=0; i<orderSize; i++) {
			out += (line_items[i] + "\n");
		}
		out += "Payments: \n";
		for(int i=0; i<paymentsSize; i++) {
			out += (payments[i] + "\n");
		}
		return out;
	}
}
