/**
 * 
 */

/**
 * @author Andy King
 * @apiNote LineItem is related to exactly one instance of Product. LineItem controls the quantity and price of a Product which is owned by either a ShoppingCart or Order isntance.
 */
public class LineItem {
	private int quantity;
	private Price price;
	private Product product;
	
	/**
	 * Create instance of LineItem
	 * @param q Quantity
	 * @param pr Product
	 * @param p Price
	 */
	public LineItem(int q, Product pr, Price p) {
		quantity = q;
		product = pr;
		price = p;
	}
	
	/**
	 * Get total of this LineItem by multiplying price by quantity
	 * @return double total
	 */
	public double getTotal() {
		return price.getAmount() * quantity;
	}
	
	/**
	 * Get quantity of this LineItem
	 * @return int quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Get price of this LineItem
	 * @return Price price
	 */
	public Price getPrice() {
		return price;
	}
	
	public String toString() {
		return quantity + "x " + product +  " at " + price + ", total: " + getTotal() + " " + price.getCurrency();
	}
}
