import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 * @apiNote ShoppingCart is owned by Account. ShoppingCart can store unlimited (100) LineItems until Account is ready to finalize an Order.
 */
public class ShoppingCart {
	private Date created;
	private int cartSize;
	private LineItem[] line_items;
	
	/**
	 * Create empty instance of ShoppingCart.
	 */
	public ShoppingCart() {
		created = new Date();
		line_items = new LineItem[100];
		cartSize = 0;
	}
	
	/**
	 * Add LineItem to this ShoppingCart
	 * @param item LineItem to add
	 */
	public void addLineItem(LineItem item) {
		line_items[cartSize] = item;
		cartSize++;
	}
	
	/**
	 * Get all LineItems in this ShoppingCart.
	 * @return LineItem[] line_items
	 */
	public LineItem[] getItems() {
		return line_items;
	}
	
	/**
	 * Get amount of LineItems in this ShoppingCart.
	 * @return int cartSize
	 */
	public int getSize() {
		return cartSize;
	}
	
	/**
	 * Delete all items from this ShoppingCart.
	 */
	public void makeEmpty() {
		cartSize = 0;
		line_items = new LineItem[100];
	}
	
	public String toString() {
		String out = "";
		for(int i=0; i<cartSize; i++) {
			out += (line_items[i] + "\n");
		}
		return out;
	}
}
