/**
 * 
 */

/**
 * @author Andy King
 * @apiNote Supplier stores the name of a supplier associated with an instance of Product.
 */

public class Supplier {
	private String name;
	
	/**
	 * Create instance of Supplier
	 * @param n Name of Supplier
	 */
	public Supplier(String n) {
		name = n;
	}
	
	public String toString() {
		return name;
	}
}
