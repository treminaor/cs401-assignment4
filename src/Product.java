/**
 * 
 */

/**
 * @author Andy King
 * @apiNode Product stores the name and supplier of a product which is for sale. A Product can be associated with with unlimited LineItems or stand alone.
 */
public class Product {
	private String id;
	private String name;
	private Supplier supplier;
	
	private static long idCounter = 0;
	
	/**
	 * Create unique sequential ID
	 * @return String id
	 */
	private static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}   
	
	/**
	 * Create instance of Product
	 * @param n Name of product
	 * @param s Supplier of product
	 */
	public Product(String n, Supplier s) {
		id = createID();
		name = n;
		supplier = s;
	}
	
	public String toString() {
		return "Product " + id + " (" + name + " from " + supplier + ")";
	}
}
