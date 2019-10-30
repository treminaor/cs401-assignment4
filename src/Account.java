import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 *
 */


public class Account {
	private String id;
	private Address billing_address;
	private boolean is_closed;
	private Date open;
	private Date closed;
	
	private ShoppingCart cart;
	private Order[] orders;
	private int ordersSize = 0;
	
	private static long idCounter = 0;
	
	/**
	 * Create unique sequential ID
	 * @return String id
	 */
	public static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}    
	
	/** 
	 * Create instance of Account.
	 */
	public Account() {
		id = createID();
		is_closed = false;
		open = new Date();
		cart = new ShoppingCart();
		orders = new Order[100];
		if(main.whitebox) System.out.println("Account(): " + this);
	}
	
	/** 
	 * Create instance of Account with web user login_id as unqiue id.
	 * @param webuser_login_id
	 */
	public Account(String webuser_login_id) {
		id = webuser_login_id;
		is_closed = false;
		open = new Date();
		cart = new ShoppingCart();
		orders = new Order[100];
		if(main.whitebox) System.out.println("Account(webuser): " + this);
	}
	
	/** 
	 * Create instance of Account with billing_address parameter
	 * @param a Address
	 */
	public Account(Address a) {
		id = createID();
		billing_address = a;
		is_closed = false;
		open = new Date();
		cart = new ShoppingCart();
		orders = new Order[100];
		if(main.whitebox) System.out.println("Account(address): " + this);
	}
	
	/** 
	 * 
	 * @return The unique ID of this Account
	 */
	public String getID() {
		if(main.whitebox) System.out.println("getID(): " + id);
		return id;
	}
	
	/** 
	 * @return ShoppingCart that this Account owns
	 */
	public ShoppingCart getCart() {
		if(main.whitebox) System.out.println("getCart(): " + cart);
		return cart;
	}
	
	/**
	 * 
	 * @param a Billing Address for this account
	 */
	public void setBillingAddress(Address a) {
		if(main.whitebox) System.out.println("setBillingAddress(address): " + a);
		billing_address = a;
	}
	
	/**
	 * Creates a new instance of Order and links all LineItems from this Account's ShoppingCart into the new Order.
	 * @return Order
	 */
	public Order createOrder() {
		Order order = new Order();
		order.convertCartToOrder(this);
		orders[ordersSize] = order;
		ordersSize++;
		if(main.whitebox) System.out.println("createOrder(): " + order);
		return order;
	}
	
	/** 
	 * @return Address set as billing_address for this Account.
	 */
	public Address getBillingAddress() {
		if(main.whitebox) System.out.println("getBillingAddress(): " + billing_address);
		return billing_address;
	}
	
	/** 
	 * Close this Account
	 */
	public void closeAccount() {
		closed = new Date();
		is_closed = true;
		if(main.whitebox) System.out.println("closeAccount(): " + is_closed);
	}
	
	public String toString() {
		if(is_closed)
			return "Account " + id + " (" + billing_address + ", " + ordersSize + " orders, " + " opened " + open + ", closed " + closed + ")";
		return "Account " + id + " (" + billing_address + ", " + ordersSize + " orders, " + " opened " + open + ")";
	}
}
