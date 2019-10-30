import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 * @apiNote Order can own unlimited (100) instances of Payment and LineItem. Instances of Order are owned by Account. All Orders have an OrderStatus.
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
	
	/**
	 * Create unique sequential ID
	 * @return String id
	 */
	private static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}   
	
	/**
	 * Create instance of Order.
	 */
	public Order() {
		number = createID();
		ordered = new Date();
		status = OrderStatus.New;
		orderSize = 0;
		line_items = new LineItem[100];
		payments = new Payment[100];
	}
	
	/**
	 * Add LineItem to this Order.
	 * @param item Item to add.
	 */
	public void addLineItem(LineItem item) {
		line_items[orderSize] = item;
		orderSize++;
		total += item.getTotal();
	}
	
	/**
	 * Add Payment to this Order.
	 * @param payment Payment to add.
	 */
	public void addPayment(Payment payment) {
		payments[paymentsSize] = payment;
		paymentsSize++;
	}
	
	/**
	 * Converts passed Account's ShoppingCart to an Order by moving all LineItems. 
	 * @param account Account to grab ShoppingCart from.
	 */
	public void convertCartToOrder(Account account) {
		ShoppingCart cart = account.getCart();
		ship_to = account.getBillingAddress();
		for(int i=0; i<cart.getSize(); i++) {
			addLineItem(cart.getItems()[i]);
		}
		cart.makeEmpty();
	}
	
	/**
	 * Gets current status of this Order.
	 * @return OrderStatus enum
	 */
	public OrderStatus getStatus() {
		return status;
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
