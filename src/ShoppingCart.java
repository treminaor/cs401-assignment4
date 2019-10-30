import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 *
 */
public class ShoppingCart {
	private Date created;
	private int cartSize;
	private LineItem[] line_items;
	
	public ShoppingCart() {
		created = new Date();
		line_items = new LineItem[100];
		cartSize = 0;
	}
	
	public void addLineItem(LineItem item) {
		line_items[cartSize] = item;
		cartSize++;
	}
	
	public LineItem[] getItems() {
		return line_items;
	}
	
	public int getSize() {
		return cartSize;
	}
	
	public String toString() {
		String out = "";
		for(int i=0; i<cartSize; i++) {
			out += (line_items[i] + "\n");
		}
		return out;
	}
}
